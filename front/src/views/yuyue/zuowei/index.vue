<template>
  <div style="position:absolute;width: 100%">
    <el-select  v-model="value" placeholder="请选择" class="listmenu" @change="listchange">
      <el-option-group
          v-for="group in options"
          :key="group.label"
          :label="group.label">
        <el-option
            v-for="item in group.options"
            :key="item.value"
            :label="item.label"
            :value="item.value">
        </el-option>
      </el-option-group>
    </el-select>
    <el-carousel ref="rooms" indicator-position="outside" :autoplay="false" id="mainbox" :height=screenHeight style="height: 100%;width: 90%" arrow="never" @change="chushihua">
      <el-carousel-item v-for="it in rooms" :key="rooms" :name="it" style="height: 100%">
        <p id="title">{{it}}</p>
        <img src="../zixishi01.png" class="img_class"/>

        <el-button :id="(() => it+ 'B1')()" type="primary" class="zuoweibutton"
                   style="width: 3.4%;height: 9.2%;margin-left: 22.8%;margin-top: 37.8%" @click="zuoweiclick"><p class="zuoweitext">B1</p></el-button>
        <el-button :id="(() => it+ 'B2')()" type="primary" class="zuoweibutton"
                   style="width: 3.4%;height: 9.2%;margin-left: 22.8%;margin-top: 33.2%" @click="zuoweiclick"><p class="zuoweitext">B2</p></el-button>
        <el-button :id="(() => it+ 'B3')()" type="primary" class="zuoweibutton"
                   style="width: 3.4%;height: 9.2%;margin-left: 22.8%;margin-top: 28.5%" @click="zuoweiclick"><p class="zuoweitext">B3</p></el-button>
        <el-button :id="(() => it+ 'B4')()" type="primary" class="zuoweibutton"
                   style="width: 3.4%;height: 9.2%;margin-left: 22.8%;margin-top: 23.8%" @click="zuoweiclick"><p class="zuoweitext">B4</p></el-button>
        <el-button :id="(() => it+ 'B5')()" type="primary" class="zuoweibutton"
                   style="width: 3.4%;height: 9.2%;margin-left: 22.8%;margin-top: 19.1%" @click="zuoweiclick"><p class="zuoweitext">B5</p></el-button>
        <el-button :id="(() => it+ 'B6')()" type="primary" class="zuoweibutton"
                   style="width: 3.4%;height: 9.2%;margin-left: 22.8%;margin-top: 14.5%" @click="zuoweiclick"><p class="zuoweitext">B6</p></el-button>
        <el-button :id="(() => it+ 'B7')()" type="primary" class="zuoweibutton"
                   style="width: 3.4%;height: 9.2%;margin-left: 22.8%;margin-top: 9.8%" @click="zuoweiclick"><p class="zuoweitext">B7</p></el-button>
        <el-button :id="(() => it+ 'B8')()" type="primary" class="zuoweibutton"
                   style="width: 4.2%;height: 7.5%;margin-left: 28.2%;margin-top: 2.3%" @click="zuoweiclick"><p class="zuoweitext">B8</p></el-button>
        <el-button :id="(() => it+ 'B9')()" type="primary" class="zuoweibutton"
                   style="width: 4.3%;height: 7.5%;margin-left: 32.65%;margin-top: 2.3%" @click="zuoweiclick"><p class="zuoweitext">B9</p></el-button>
        <el-button :id="(() => it+ 'B10')()" type="primary" class="zuoweibutton"
                   style="width: 4.3%;height: 7.5%;margin-left: 37.1%;margin-top: 2.3%" @click="zuoweiclick"><p class="zuoweitext">B10</p></el-button>

        <el-button :id="(() => it+ 'B11')()" type="primary" class="zuoweibutton"
                   style="width: 4.3%;height: 7.5%;margin-left: 39.3%;margin-top: 39.1%" @click="zuoweiclick"><p class="zuoweitext">B11</p></el-button>
        <el-button :id="(() => it+ 'B12')()" type="primary" class="zuoweibutton"
                   style="width: 4.3%;height: 7.5%;margin-left: 43.7%;margin-top: 39.1%" @click="zuoweiclick"><p class="zuoweitext">B12</p></el-button>

        <el-button :id="(() => it+ 'B13')()" type="primary" class="zuoweibutton"
                   style="width: 4.3%;height: 7.5%;margin-left: 39.3%;margin-top: 27.3%" @click="zuoweiclick"><p class="zuoweitext">B13</p></el-button>
        <el-button :id="(() => it+ 'B14')()" type="primary" class="zuoweibutton"
                   style="width: 4.3%;height: 7.5%;margin-left: 43.7%;margin-top: 27.3%" @click="zuoweiclick"><p class="zuoweitext">B14</p></el-button>

        <el-button :id="(() => it+ 'B15')()" type="primary" class="zuoweibutton"
                   style="width: 4.3%;height: 7.5%;margin-left: 39.3%;margin-top: 23.4%" @click="zuoweiclick"><p class="zuoweitext">B15</p></el-button>
        <el-button :id="(() => it+ 'B16')()" type="primary" class="zuoweibutton"
                   style="width: 4.3%;height: 7.5%;margin-left: 43.7%;margin-top: 23.4%" @click="zuoweiclick"><p class="zuoweitext">B16</p></el-button>

        <el-button :id="(() => it+ 'B17')()" type="primary" class="zuoweibutton"
                   style="width: 4.3%;height: 7.5%;margin-left: 39.3%;margin-top: 11.4%" @click="zuoweiclick"><p class="zuoweitext">B17</p></el-button>
        <el-button :id="(() => it+ 'B18')()" type="primary" class="zuoweibutton"
                   style="width: 4.3%;height: 7.5%;margin-left: 43.7%;margin-top: 11.4%" @click="zuoweiclick"><p class="zuoweitext">B18</p></el-button>

        <el-button :id="(() => it+ 'A1')()" type="primary" class="zuoweibutton"
                   style="width: 3.4%;height: 9.2%;margin-left: 49%;margin-top: 30.4%" @click="zuoweiclick"><p class="zuoweitext">A1</p></el-button>
        <el-button :id="(() => it+ 'A2')()" type="primary" class="zuoweibutton"
                   style="width: 3.4%;height: 9.2%;margin-left: 49%;margin-top: 25.6%" @click="zuoweiclick"><p class="zuoweitext">A2</p></el-button>
        <el-button :id="(() => it+ 'A3')()" type="primary" class="zuoweibutton"
                   style="width: 3.4%;height: 9.2%;margin-left: 49%;margin-top: 20.9%" @click="zuoweiclick"><p class="zuoweitext">A3</p></el-button>
        <el-button :id="(() => it+ 'A4')()" type="primary" class="zuoweibutton"
                   style="width: 3.4%;height: 9.2%;margin-left: 49%;margin-top: 16.1%" @click="zuoweiclick"><p class="zuoweitext">A4</p></el-button>
        <el-button :id="(() => it+ 'A5')()" type="primary" class="zuoweibutton"
                   style="width: 3.4%;height: 9.2%;margin-left: 49%;margin-top: 11.4%" @click="zuoweiclick"><p class="zuoweitext">A5</p></el-button>

        <el-button :id="(() => it+ 'A6')()" type="primary" class="zuoweibutton"
                   style="width: 4.3%;height: 7.5%;margin-left: 54.2%;margin-top: 4.2%" @click="zuoweiclick"><p class="zuoweitext">A6</p></el-button>
        <el-button :id="(() => it+ 'A7')()" type="primary" class="zuoweibutton"
                   style="width: 4.3%;height: 7.5%;margin-left: 58.65%;margin-top: 4.2%" @click="zuoweiclick"><p class="zuoweitext">A7</p></el-button>
        <el-button :id="(() => it+ 'A8')()" type="primary" class="zuoweibutton"
                   style="width: 4.3%;height: 7.5%;margin-left: 63.1%;margin-top: 4.2%" @click="zuoweiclick"><p class="zuoweitext">A8</p></el-button>

        <el-button :id="(() => it+ 'A9')()" type="primary" class="zuoweibutton"
                   style="width: 4.3%;height: 7.5%;margin-left: 63.85%;margin-top: 31.4%" @click="zuoweiclick"><p class="zuoweitext">A9</p></el-button>
        <el-button :id="(() => it+ 'A10')()" type="primary" class="zuoweibutton"
                   style="width: 4.3%;height: 7.5%;margin-left: 68.3%;margin-top: 31.4%" @click="zuoweiclick"><p class="zuoweitext">A10</p></el-button>

        <el-button :id="(() => it+ 'A11')()" type="primary" class="zuoweibutton"
                   style="width: 4.3%;height: 7.5%;margin-left: 63.85%;margin-top: 20%" @click="zuoweiclick"><p class="zuoweitext">A11</p></el-button>
        <el-button :id="(() => it+ 'A12')()" type="primary" class="zuoweibutton"
                   style="width: 4.3%;height: 7.5%;margin-left: 68.3%;margin-top: 20%" @click="zuoweiclick"><p class="zuoweitext">A12</p></el-button>

        <el-button :id="(() => it+ 'A13')()" type="primary" class="zuoweibutton"
                   style="width: 4.3%;height: 7.5%;margin-left: 63.85%;margin-top: 16.2%" @click="zuoweiclick"><p class="zuoweitext">A13</p></el-button>
        <el-button :id="(() => it+ 'A14')()" type="primary" class="zuoweibutton"
                   style="width: 4.3%;height: 7.5%;margin-left: 68.3%;margin-top: 16.2%" @click="zuoweiclick"><p class="zuoweitext">A14</p></el-button>



      </el-carousel-item>
    </el-carousel>

    <!-- 添加或修改配置对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="zuoweiRef" :model="form" :rules="rules" label-width="100px">
        <el-form-item label="申请人">
          <p style="text-align: center;margin: 0;padding: 0;padding-left:10px">{{form.userName}}</p>
        </el-form-item>
        <el-form-item label="预约座位">
          <p style="text-align: center;margin: 0;padding: 0;padding-left:10px">{{form.zuoweiId}}</p>
        </el-form-item>
        <el-form-item label="开始时间" required>
          <el-col :span="11">
            <el-form-item prop="yuyueDate">
              <el-date-picker value-format="YYYY-MM-DD" type="date" placeholder="选择日期" v-model="form.yuyueDate" style="width: 100%;"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-form-item prop="yuyueTime">
              <el-time-picker value-format="HH:mm:ss" type="date" placeholder="选择时间" v-model="form.yuyueTime" style="width: 100%;"></el-time-picker>
            </el-form-item>
          </el-col>
        </el-form-item>
        <el-form-item label="终止时间" required>
          <el-col :span="11">
            <el-form-item prop="deDate">
              <el-date-picker value-format="YYYY-MM-DD" type="date" placeholder="选择日期" v-model="form.deDate" style="width: 100%;"></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col class="line" :span="2">-</el-col>
          <el-col :span="11">
            <el-form-item prop="deTime">
              <el-time-picker value-format="HH:mm:ss" type="date" placeholder="选择时间" v-model="form.deTime" style="width: 100%;"></el-time-picker>
            </el-form-item>
          </el-col>
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script>

import {
  addYuyue,
  getYuyueByZuoweiId,
  getYuyueNumberByUserId,
  getZuoweiByZuoweiId
} from "@/api/yuyuezuowei/yuyuezuowei.js";
import store from "@/store/index.js";
import {getUser} from "@/api/system/user.js";
import * as constants from "constants";

export default {
  components: {

  },
  data() {
    return {
      rooms:["101","201"],
      buttonlist:["B1","B2","B3","B4","B5","B6"],
      value:"",
      title:"",
      screenHeight: "1050px",
      tempnum: 0,
      tempId: 0,
      form:{},
      open:false,
      options: [{
        label: '一楼',
        options: [{
          value: '101',
          label: '101'
          }
        ]
      }, {
        label: '二楼',
        options: [{
          value: '201',
          label: '201'
          }
        ]
      }],
      rules: {
        yuyueDate: [
          { type: 'date', required: true, message: '请选择日期', trigger: 'change' }
        ],
        yuyueTime: [
          { type: 'date', required: true, message: '请选择时间', trigger: 'change' }
        ]
      },
    }
  },
  mounted() {
  },
  methods: {
    listchange(e){
      this.$refs.rooms.setActiveItem(e)
    },
    zuoweiclick(e){
      this.chushihua();
      let target = document.getElementById(e.currentTarget.id);
      this.handleUpdate(e.currentTarget.id);
      if(target.className == "el-button el-button--primary el-button--default zuoweibutton"){
        target.className = "el-button el-button--success el-button--default zuoweibutton"
      }else{
        target.className = "el-button el-button--primary el-button--default zuoweibutton"
      }
    },
    chushihua(e){
      let buttons = document.getElementsByClassName("el-button el-button--success el-button--default zuoweibutton")
      for(let i = 0;i < buttons.length;i++){
        buttons[i].className = "el-button el-button--primary el-button--default zuoweibutton"
      }
    },
    /** 重置新增的表单以及其他数据  */
    reset() {
      this.form = {
        zuoweiId: undefined,
        userId: undefined,
        userName: undefined,
        yuyueDate: undefined,
        yuyueTime: undefined,
        deDate: undefined,
        deTime: undefined
      };
    },
    /** 申请窗口 */
    handleUpdate(id) {
      this.reset();
      this.tempId = 0;
      this.tempnum = 0;
      getZuoweiByZuoweiId(id).then(response => {
        this.form = response.data[0];
        this.form.userId = store.state.value.user.id;
        getUser(this.form.userId).then(response1 => {
          this.form.userName = response1.data.userName;
        })
        getYuyueByZuoweiId(this.form.zuoweiId).then(res => {
          this.tempId = res.data.length;
        })
        getYuyueNumberByUserId(this.form.userId).then(res => {
          this.tempnum = res.data.length;
        })
        this.open = true;
        this.title = "预约";
      });
    },
    /** 提交按钮 */
    submitForm() {
      if(this.form.yuyueTime && this.form.yuyueDate && this.form.deTime && this.form.deDate){
        this.form.yuyueTime = this.form.yuyueDate + ' ' + this.form.yuyueTime
        this.form.deTime = this.form.deDate + ' ' + this.form.deTime
        if(this.tempnum == 0){
          if(this.tempId  == 0){
            addYuyue(this.form).then(response => {
              this.$modal.msgSuccess("预约成功");
              this.open = false;
            })
          }else{
            this.$modal.msgError("预约失败，座位已经被预约");
            this.open = false;
          }
        }else{
          this.$modal.msgError("预约失败，已经有了一个预约");
          this.open = false;
        }
      }else{
        this.$modal.msgError("请选择时间");
      }
    },
    /** 取消按钮 */
    cancel() {
      this.open = false;
      this.reset();
    }
  },
  watch: {
  }
}
</script>

<style>
#mainbox{
  height: 92%;
  width: 84%;
  margin-left: 8%;
  margin-top: 4%;
  position: relative;
}
#title{
  color: #1c84c6;
  margin-left: 48.5%;
  font-size: 50px;
  position: absolute;
  font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
}
.img_class{
  height: 95%;
  width: 52.3%;
  margin-left: 21.35%;
  margin-top: 1%;
  position: absolute;
}
.zuoweibutton{
  position: absolute;
  opacity: 1;
}
.zuoweitext{
  font-size: 30px;
}
.listmenu{
  position: absolute;
  margin-left: 50px;
  margin-top: 10px;
  width: 300px;
  z-index: 1
}
.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 300px;
  margin: 0px;
}

.el-carousel__item:nth-child(2n) {
  background-color: white;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: white;
}
</style>

