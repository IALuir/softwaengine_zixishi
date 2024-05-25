<template>
  <el-row>
    <el-col :span="24"><p class="tiemfont">{{now_time}}</p></el-col>
    <el-col :span="24" v-if="hasyuyue">
      <p class="qiandaoshijian" v-if="state1">{{qiandao}}</p><p class="qiandaoshijian" v-if="state2">{{qiandao}}</p>
      <p class="qiandaoshijian">{{qiandaoshijian}}</p></el-col>
    <el-col :span="24" v-if="hasyuyue"><p class="zuowei">预约的座位：{{zuowei}}</p></el-col>
    <el-col :span="24" v-if="hasyuyue">
      <el-button type="primary" id="qiandao" v-if="state1" @click="qiandao_button()">签到</el-button>
      <el-button type="primary" id="qiantui" v-if="state2" @click="qiantui_button()">签退</el-button>
    </el-col>
    <el-col :span="24" v-if="noyuyue"><p class="zuowei">您没有预约记录！</p></el-col>

  </el-row>
</template>

<script>

import {
  addQiandao,
  getQiandaoByyuyueId,
  getYuyueNumberByUserId, updateQiandao
} from "@/api/yuyuezuowei/yuyuezuowei.js";
import store from "@/store/index.js";

export default {
  components: {

  },
  data() {
    return {
      state1:true,
      state2:false,
      hasyuyue:true,
      noyuyue:false,
      qiandao:"签到的时间为：",
      qiantui:"签退的时间为：",
      now_time: "00:00:00",
      qiandaoshijian: 0,
      qiantuishijian: 0,
      zuowei: undefined,
      yuyueId:undefined,
      qiandaoId:undefined,
      form:{
        qiandaoId:undefined,
        yuyueId:undefined,
        qiandaoTime:undefined,
        qiantuiTime:"1900/1/1 00:00:00",
        state:undefined
      }
    }
  },
  mounted() {
    this.getzuowei();
    setInterval(() => {
      this.now_time = this.currentTime();
    }, 1000);
  },
  methods: {
    currentTime() {
      let date = new Date();
      let year = date.getFullYear();
      let month = date.getMonth();
      let dateArr = [
        date.getMonth() + 1,
        date.getDate(),
        date.getHours(),
        date.getMinutes(),
        date.getSeconds(),
      ];
      if(dateArr[2] < 10) dateArr[2] = '0' + dateArr[2]
      if(dateArr[3] < 10) dateArr[3] = '0' + dateArr[3]
      if(dateArr[4] < 10) dateArr[4] = '0' + dateArr[4]
      return year +
          "/" +
          dateArr[0] +
          "/" +
          dateArr[1] +
          " " +
          dateArr[2] +
          ":" +
          dateArr[3] +
          ":" +
          dateArr[4]
    },
    getzuowei(){
      getYuyueNumberByUserId(store.state.value.user.id).then(res => {
        if(res.data.length){
          this.zuowei = res.data[0].zuoweiId;
          this.qiandaoshijian = res.data[0].yuyueTime;
          this.qiantuishijian = res.data[0].deTime;
          this.yuyueId = res.data[0].yuyueId;
          getQiandaoByyuyueId(this.yuyueId).then(res => {
            if(res.data.length){
              if(res.data[0].qiandao_state == 0){
                this.state1 = true;
                this.state2 = false;
              }else if(res.data[0].qiandao_state == 2 || res.data[0].qiandao_state == 5){
                this.state1 = false;
                this.state2 = true;
              }else{
                this.hasyuyue = false;
                this.noyuyue = true;
              }
              this.qiandaoId = res.data[0].qiandaoId;
            }
          })
        }
      })
    },
    qiandao_button(){
      this.reset() //0：未到签到时间 1：正常签到，正常签退 2:正常签到，未到签退时间 3:正常签到,未签退 4:正常签到,超时签退 5:超时签到,未到签退时间 6:超时签到，超时签退 7:未签到
      let temptime = new Date(this.qiandaoshijian) - new Date(this.currentTime());
      this.from.qiandaoId = this.qiandaoId;
      this.from.yuyueId = this.yuyueId;
      this.from.qiandaoTime = this.now_time;
      if(temptime > -300000 && temptime < 300000){
        this.$modal.msgSuccess("签到成功");
        this.from.state = 2;
        this.state1 = false;
        this.state2 = true;
      }else if(temptime < -300000 && -1800000 < temptime){
        this.$modal.msgSuccess("超时签到，签到成功");
        this.from.state = 5;
        this.state1 = false;
        this.state2 = true;
      }else{
        this.$modal.msgError("不在签到时间内");
      }
      getQiandaoByyuyueId(this.yuyueId).then(res => {
        if(res.data.length){
          updateQiandao(this.from)
        }else{
          addQiandao(this.from)
        }
        this.getzuowei();
      })
    },
    qiantui_button(){
      this.reset() //0：未到签到时间 1：正常签到，正常签退 2:正常签到，未到签退时间 3:正常签到,未签退 4:正常签到,超时签退 5:超时签到,未到签退时间 6:超时签到，超时签退 7:未签到
      let temptime = new Date(this.qiantuishijian) - new Date(this.currentTime());
      this.from.qiandaoId = this.qiandaoId;
      this.from.yuyueId = this.yuyueId;
      this.from.qiantuiTime = this.now_time;
      if(temptime > -300000 && temptime < 300000){
        this.$modal.msgSuccess("签退成功");
        this.from.state = 1;
        this.state1 = false;
        this.state2 = true;
      }else if(temptime < -300000 && -1800000 < temptime){
        this.$modal.msgSuccess("超时签退，签退成功");
        this.from.state = 4;
        this.state1 = false;
        this.state2 = true;
      }else{
        this.$modal.msgError("不在签退时间内");
      }
      getQiandaoByyuyueId(this.yuyueId).then(res => {
        if(res.data.length){
          this.from.qiandaoTime = res.data[0].qiandaoTime;
          updateQiandao(this.from)
        }
        this.getzuowei();
      })
    },
    reset(){
      this.from = {
        qiandaoId:undefined,
        yuyueId:undefined,
        qiandaoTime:undefined,
        qiantuiTime:"1900/1/1 00:00:00",
        state:undefined
      }
    }
  },
  watch: {
  }
}
</script>

<style>
#qiandao{
  width: 40%;
  min-height: 200px;
  margin-left: 30%;
  position: absolute;
  font-size: 120px;
}
#qiantui{
  width: 40%;
  min-height: 200px;
  margin-left: 30%;
  position: absolute;
  font-size: 120px;
}
.bg-purple-dark {
  background: rgba(153, 169, 191, 0.75);
}

.grid-content {
  border-radius: 50px;
  min-height: 490%;
  width: 30%;
  margin-left: 35%;
  text-align: center;
  font-size: 80px;
  font-family: "微软雅黑";
}
.tiemfont{
  font-size: 120px;
  z-index: 1;
  color: rgba(54, 45, 45, 0.75);
  text-align: center;
  margin-top: 5%;
  font-family: Arial Black;
}
.qiandaoshijian{
  font-size: 60px;
  z-index: 1;
  color: rgba(169, 15, 79, 0.75);
  text-align: center;
  font-family: Arial Black;
  margin: 0;
}
.zuowei{
  font-size: 40px;
  z-index: 1;
  color: rgba(54, 45, 45, 0.75);
  text-align: center;
  font-family: Arial Black;
}
</style>

