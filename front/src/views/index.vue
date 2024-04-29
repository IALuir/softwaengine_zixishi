<template>
  <list1/>

  <mid/>

  <list2/>
</template>

<script>
import list1 from '@/views/chart/list1.vue'
import list2 from '@/views/chart/list2.vue'
import mid from '@/views/chart/mid.vue'

export default {
  components: {
    list1,
    list2,
    mid
  },
  data() {
    return {
    }
  },
  mounted() {
  },
  methods: {
  },
  watch: {
  }
}
</script>

<style>
#leftbox{
  width: 18%;
  height: 99%;
  margin:5px;
  position: absolute;
  z-index: 1;
  opacity:0.5;
  background-color: rgb(0, 0, 0, 0.6);
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  backdrop-filter: blur(6px);
}
#midbox{
  width: 100%;
  height: 100%;
  position: absolute;
  padding: 0;
  margin: 0;
}
#rightbox{
  width: 18%;
  height: 99%;
  margin:5px;
  margin-left: 81.8%;
  position: absolute;
  z-index: 1;
  opacity:0.5;
  background-color: rgba(0, 0, 0, 0.6);
  box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
  backdrop-filter: blur(6px);
}
.el-row {
  margin: 5px;
  &:last-child {
    margin-bottom: 0;
  }
}
.el-col {
  border-radius: 4px;
}
.bg-title {
  background: #409EFF;
}
.bg-purple-dark {
  background: rgba(177, 177, 177, 0.3);
  border-radius: 10px;

}
.grid-content {
  border-radius: 4px;
  min-height: 60px;
}
.listfont{
  text-align: center;
  font-size: 18px;
  min-height: 60px;
  padding-top: 18px;
  color: white;
}
.listnum{
  text-align: center;
  font-size: 20px;
  min-height: 60px;
  padding-top: 18px;
  color: white;
}
#streaminVideo{
  object-fit:fill;
}
</style>

