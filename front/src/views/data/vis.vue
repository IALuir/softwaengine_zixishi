
<template>
    <div id="people" style="width: 45%; height: 400px; padding-top: 20px"></div>
    <div id="money" style="width: 45%; height: 400px; padding-top: 10px; position: absolute;top: 0; right: 40px"></div>
    <div id="LineGraph" style="width: 100%; height: 300px;"></div>
  <div style="padding-left: 90px;padding-bottom: 30px">
    <el-row :gutter="20">
      <el-col :span="6">
        <div>
          <el-statistic
              group-separator=","
              :precision="0"
              :value="value1"
              :title="title1"
          ></el-statistic>
        </div>
      </el-col>
      <el-col :span="6">
        <div>
          <el-statistic title="白黑天预约时间比例" value="211：102">
            <template slot="formatter">
            </template>
          </el-statistic>
        </div>
      </el-col>
      <el-col :span="6">
        <div>
          <el-statistic
              group-separator=","
              :precision="0"
              decimal-separator="."
              :value="value2"
              :title="title2"
          >
            <template slot="prefix">
              <i class="el-icon-s-flag" style="color: red"></i>
            </template>
            <template slot="suffix">
              <i class="el-icon-s-flag" style="color: blue"></i>
            </template>
          </el-statistic>
        </div>
      </el-col>
      <el-col :span="6">
        <div>
          <el-statistic :value="like ? 21 : 20" title="反馈意见（条）">
            <template slot="suffix">
              <span @click="like = !like" class="like">
                <i
                    class="el-icon-star-on"
                    style="color:red"
                    v-show="!!like"
                ></i>
                <i class="el-icon-star-off" v-show="!like"></i>
              </span>
            </template>
          </el-statistic>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import * as echarts from 'echarts';
import {Discount} from "@element-plus/icons-vue";
export default {
  components: {Discount},
  data() {
    return {
      like: true,
      value1: 2154,
      value2: 1314,
      title1: "本月一楼预约总人数",
      title2:"本月二楼预约总人数",
      chartDom:undefined,
      myMoneyData:undefined,
      myChart: undefined,
      lineChart: undefined,
      peopleOption:{
        title: {
          text: '上周预约人数',
          left: 'center'
        },
        tooltip: {},
        legend: {
          data: ['人数'],
          left: 'right'
        },
        xAxis: {
          data: ['周一', '周二', '周三', '周四', '周五', '周六','周日']
        },
        yAxis: {},
        series: [
          {
            name: '人数',
            type: 'bar',
            data: [81, 45, 36, 53, 78, 24,39]
          }
        ]
      },
      moneydata:{
        tooltip: {
          trigger: 'item'
        },
        legend: {
          top: '3%',
          left: 'center'
        },
        series: [
          {
            name: '上周预约时长',
            type: 'pie',
            radius: ['40%', '70%'],
            avoidLabelOverlap: false,
            itemStyle: {
              borderRadius: 10,
              borderColor: '#fff',
              borderWidth: 2
            },
            label: {
              show: false,
              position: 'center'
            },
            emphasis: {
              label: {
                show: true,
                fontSize: 40,
                fontWeight: 'bold'
              }
            },
            labelLine: {
              show: false
            },
            data: [
              { value: 409, name: '周一总时长' },
              { value: 335, name: '周二总时长' },
              { value: 280, name: '周三总时长' },
              { value: 388, name: '周四总时长' },
              { value: 480, name: '周五总时长' },
              { value: 267, name: '周六总时长' },
              { value: 302, name: '周日总时长' },
            ]
          }
        ]
      },
      linedata:{
        title: {
          text: '本月预约人数',
          left: 'center'
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: ['5-1', '5-2', '5-3', '5-4', '5-5', '5-6', '5-7','5-8','5-9','5-10','5-11','5-12','5-13','5-14','5-15','5-16','5-17','5-18','5-19','5-20','5-21','5-22','5-23','5-24','5-25','5-26','5-27','5-28','5-29', +
          '5-30','5-31']
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            data: [52, 87, 68, 22, 75, 84, 43, 98, 64, 36, 56, 92, 30, 77, 27, 90, 46, 94, 70, 29, 86, 25, 63, 38, 89, 51, 79, 66, 39, 0],
            type: 'line',
            areaStyle: {}
          }
        ]
      }
    }
    },
  mounted() {
    this.myChart =echarts.init(document.getElementById('people'));
    this.myChart.setOption(this.peopleOption);
    this.chartDom = document.getElementById('money');
    this.myMoneyData = echarts.init(this.chartDom);
    this.myMoneyData.setOption(this.moneydata);
    this.lineChart = echarts.init(document.getElementById('LineGraph'));
    this.lineChart.setOption(this.linedata);
  },
  methods: {
  },
  watch: {
  }
}


</script>

<style lang="scss">
.like {
  cursor: pointer;
  font-size: 25px;
  display: inline-block;
}
</style>