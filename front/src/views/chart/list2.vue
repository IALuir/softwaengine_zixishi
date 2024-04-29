<template>
  <div id="rightbox">
    <el-row>
      <el-col :span="24"><div class="grid-content bg-title titlefont1" style="min-height: 40px">设备列表</div></el-col>
    </el-row>
    <el-row>
      <el-col :span="12"><div class="grid-content listfont">设备1</div></el-col>
      <el-col :span="12"><el-button v-bind:type="button1" style="margin-top: 6%;margin-left: 25%;width: 50%" @click="UE_test1">视角跳转</el-button></el-col>
    </el-row>
    <el-row>
      <el-col :span="12"><div class="grid-content listfont">设备2</div></el-col>
      <el-col :span="12"><el-button v-bind:type="button2" style="margin-top: 6%;margin-left: 25%;width: 50%" @click="UE_test2">视角跳转</el-button></el-col>
    </el-row>
    <el-row>
      <el-col :span="12"><div class="grid-content listfont">设备3</div></el-col>
      <el-col :span="12"><el-button v-bind:type="button3" style="margin-top: 6%;margin-left: 25%;width: 50%" @click="UE_test3">视角跳转</el-button></el-col>
    </el-row>
    <el-row>
      <el-col :span="12"><div class="grid-content listfont">设备4</div></el-col>
      <el-col :span="12"><el-button v-bind:type="button4" style="margin-top: 6%;margin-left: 25%;width: 50%" @click="UE_test4">视角跳转</el-button></el-col>
    </el-row>

    <el-row>
      <el-col :span="24">
        <el-button type="primary" style="margin-left: 25%;width: 50%">设备详细</el-button>
        <el-button v-bind:type="button5" style="width: 20%" @click="UE_re">重置视角</el-button>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="24"><div class="grid-content bg-title titlefont1" style="min-height: 40px;margin-top: 100%">设备1 污染数据</div></el-col>
    </el-row>
    <el-row>
      <el-col :span="24">
        <div class="grid-content " style="margin-left: 5px;height: 340px">
          <div id="right_line" style="width: 100%;height: 100%"></div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import * as echarts from 'echarts';
import {pixelStreaming} from '@/views/chart/mid.vue'
let myChart;
let option;

export default {
  data(){
    return{
      button1:"primary",
      button2:"primary",
      button3:"primary",
      button4:"primary",
      button5:"success",

    }
  },
  mounted() {
    myChart = echarts.init(document.getElementById("right_line"));
    option = {
      tooltip: {
        trigger: 'axis',
        axisPointer: {
          type: 'shadow'
        }
      },
      grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
      },
      xAxis: [
        {
          type: 'category',
          data: ['五天前', '四天前', '三天前', '前天', '昨天', '今天', '明天'],
          axisTick: {
            alignWithLabel: true
          },
          axisLabel:{
            textStyle: {
              color:'#ffffff',
            }
          }
        }
      ],
      yAxis: [
        {
          type: 'value',
          axisLabel:{
            textStyle: {
              color:'#ffffff',
            }
          }
        }
      ],
      series: [
        {
          name: 'Direct',
          type: 'bar',
          barWidth: '60%',
          data: [41.5, 52, 48, 42, 62, 63, 66]
        }
      ]
    };
    myChart.setOption(option);
  },
  methods:{
    UE_test1(){
      const descriptor = {
        position: "1",
      };
      pixelStreaming.emitUIInteraction(descriptor);
      this.button1 = "success"
      this.button2 = "primary"
      this.button3 = "primary"
      this.button4 = "primary"
      this.button5 = "primary"
      console.log(descriptor)
    },
    UE_test2(){
      const descriptor = {
        position: "2",
      };
      pixelStreaming.emitUIInteraction(descriptor);
      this.button1 = "primary"
      this.button2 = "success"
      this.button3 = "primary"
      this.button4 = "primary"
      this.button5 = "primary"
      console.log(descriptor)
    },
    UE_test3(){
      const descriptor = {
        position: "3",
      };
      pixelStreaming.emitUIInteraction(descriptor);
      this.button1 = "primary"
      this.button2 = "primary"
      this.button3 = "success"
      this.button4 = "primary"
      this.button5 = "primary"
      console.log(descriptor)
    },
    UE_test4(){
      const descriptor = {
        position: "4",
      };
      pixelStreaming.emitUIInteraction(descriptor);
      this.button1 = "primary"
      this.button2 = "primary"
      this.button3 = "primary"
      this.button4 = "success"
      this.button5 = "primary"
      console.log(descriptor)
    },
    UE_re(){
      const descriptor = {
        position: "-1",
      };
      pixelStreaming.emitUIInteraction(descriptor);
      this.button1 = "primary"
      this.button2 = "primary"
      this.button3 = "primary"
      this.button4 = "primary"
      this.button5 = "success"
      console.log(descriptor)
    }
  }
}
</script>

<style>

</style>
