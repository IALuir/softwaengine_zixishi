<template>
  <div id="leftbox">
    <el-row>
      <el-col :span="24"><div class="grid-content bg-title titlefont1" style="min-height: 40px;">环境数据</div></el-col>
    </el-row>
    <el-row>
      <el-col :span="6"><div class="grid-content  listfont"></div></el-col>
      <el-col :span="18" class="">
        <div class="grid-content" style="margin-left: 5px">
          <div class="list1 listnum">监测点1</div>
          <div class="list1 listnum">监测点2</div>
          <div class="list1 listnum">监测点3</div>
        </div>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="6"><div class="grid-content  listfont">温度</div></el-col>
      <el-col :span="18" class="bg-purple-dark">
        <div class="grid-content  " style="margin-left: 5px">
          <div class="list1 listnum">22.5</div>
          <div class="list1 listnum">26.8</div>
          <div class="list1 listnum">17.8</div>
        </div>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="6"><div class="grid-content  listfont">湿度</div></el-col>
      <el-col :span="18" class="bg-purple-dark">
        <div class="grid-content  " style="margin-left: 5px">
          <div class="list1 listnum">0.12</div>
          <div class="list1 listnum">0.44</div>
          <div class="list1 listnum">0.18</div>
        </div>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="6"><div class="grid-content  listfont">PM5.2</div></el-col>
      <el-col :span="18" class="bg-purple-dark">
        <div class="grid-content  " style="margin-left: 5px">
          <div class="list1 listnum">23</div>
          <div class="list1 listnum">11</div>
          <div class="list1 listnum">87</div>
        </div>
      </el-col>
    </el-row>

    <el-row style="min-height: 40px"></el-row>

    <el-row>
      <el-col :span="24"><div class="grid-content bg-title titlefont1" style="min-height: 40px">水质数据</div></el-col>
    </el-row>
    <el-row>
      <el-col :span="6"><div class="grid-content  listfont"></div></el-col>
      <el-col :span="18" class="">
        <div class="grid-content  " style="margin-left: 5px">
          <div class="list1 listnum">监测点1</div>
          <div class="list1 listnum">监测点2</div>
          <div class="list1 listnum">监测点3</div>
        </div>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="6"><div class="grid-content  listfont">氨氮</div></el-col>
      <el-col :span="18" class="bg-purple-dark">
        <div class="grid-content  " style="margin-left: 5px">
          <div class="list1 listnum">9.34</div>
          <div class="list1 listnum">9.84</div>
          <div class="list1 listnum">10.5</div>
        </div>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="6"><div class="grid-content  listfont">浊度</div></el-col>
      <el-col :span="18" class="bg-purple-dark">
        <div class="grid-content  " style="margin-left: 5px">
          <div class="list1 listnum">277</div>
          <div class="list1 listnum">325</div>
          <div class="list1 listnum">189</div>
        </div>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="6"><div class="grid-content  listfont">总磷</div></el-col>
      <el-col :span="18" class="bg-purple-dark">
        <div class="grid-content  " style="margin-left: 5px">
          <div class="list1 listnum">0.38</div>
          <div class="list1 listnum">0.28</div>
          <div class="list1 listnum">0.25</div>
        </div>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="6"><div class="grid-content  listfont">电导率</div></el-col>
      <el-col :span="18" class="bg-purple-dark">
        <div class="grid-content  " style="margin-left: 5px">
          <div class="list1 listnum">950</div>
          <div class="list1 listnum">800</div>
          <div class="list1 listnum">922</div>
        </div>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="6"><div class="grid-content  listfont">总氨</div></el-col>
      <el-col :span="18" class="bg-purple-dark">
        <div class="grid-content  " style="margin-left: 5px">
          <div class="list1 listnum">5</div>
          <div class="list1 listnum">5.3</div>
          <div class="list1 listnum">6.25</div>
        </div>
      </el-col>
    </el-row>

    <el-row style="min-height: 40px"></el-row>

    <el-row>
      <el-col :span="24"><div class="grid-content bg-title titlefont1" style="min-height: 40px">设备1 液位数据</div></el-col>
    </el-row>
    <el-row>
      <el-col :span="24">
        <div class="grid-content" style="margin-left: 5px;height: 340px">
          <div id="left_line" style="width: 100%;height: 100%"></div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import * as echarts from 'echarts';
let myChart;
let option;

export default {
  data(){
    return{

    }
  },
  mounted() {
    myChart = echarts.init(document.getElementById("left_line"));
    option = {
      tooltip: {
        trigger: 'axis'
      },
      xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['五天前', '四天前', '三天前', '前天', '昨天', '今天', '明天'],
        axisLabel:{
          textStyle: {
            color:'#ffffff',
          }
        }
      },
      yAxis: {
        type: 'value',
        axisLabel:{
          textStyle: {
            color:'#ffffff',
          }
        }
      },
      series: [
        {
          data: [44, 66, 63, 68, 77, 83, 88],
          type: 'line',
          areaStyle: {
            color: echarts.graphic.LinearGradient(0, 0, 0, 1, [
              { offset: 0, color: "#48C78E" },
              { offset: 0.5, color: "rgba(0,0,255,0.3)" },
              { offset: 1, color: "rgba(0,0,255,0.1)" },
            ])
          },
        }
      ]
    };
    myChart.setOption(option);
  }
}
</script>

<style>
.list1 {
  width: 33%;
  height: 100%;
  float:left;
}
.titlefont1{
  padding-top: 10px;
  padding-left: 10px;
  color:white;
}
</style>
