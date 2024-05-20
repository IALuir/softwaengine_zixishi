<template>
  <div class="homeclass">
    <el-row>
      <el-col :span="24"><p class="tiemfont">{{now_time}}</p></el-col>
      <el-col :span="24"><el-button class="grid-content bg-purple-dark" @click="gotoyuyue" >我 要 预 约</el-button></el-col>
    </el-row>
  </div>


</template>

<script>
export default {
  components: {

  },
  data() {
    return {
      now_time: "00:00:00"
    }
  },
  mounted() {
    setInterval(() => {
      this.now_time = this.currentTime();
    }, 1000);
  },
  methods: {
    gotoyuyue(){
      this.$router.push({
        path:'/yuyue/yuyuezuowei'
      })
    },
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
      return " " +
          dateArr[2] +
          ":" +
          dateArr[3] +
          ":" +
          dateArr[4]
    }
  },
  watch: {
  }
}
</script>

<style>
.homeclass{
  width: 100%;
  height: 100%;
  background-image: url(home.jpg);
  background-size:cover;
  background-repeat: no-repeat;
  background-position: center;
  position: absolute;
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
  font-size: 200px;
  z-index: 1;
  color: rgba(255, 255, 255, 0.75);
  text-align: center;
  margin-top: 5%;
  font-family: Arial Black;
}

</style>

