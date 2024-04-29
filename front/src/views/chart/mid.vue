<template>
  <div id="midbox">

  </div>
<!--  <el-button type="danger" style="margin-top: 6%;margin-left: 40%;width: 20%;min-height: 100px;position: absolute" >设备1 数值超出阈值！</el-button>-->
</template>

<script lang="ts">
import { Config, PixelStreaming } from '@epicgames-ps/lib-pixelstreamingfrontend-ue5.3';
import { Application, PixelStreamingApplicationStyle } from '@epicgames-ps/lib-pixelstreamingfrontend-ui-ue5.3';
export let pixelStreaming
document.body.onload = function() {
  const config = new Config({
    initialSettings: {
      AutoPlayVideo: true,
      AutoConnect: true,
      ss: "ws://10.246.56.163:80",
      StartVideoMuted: true,
      WaitForStreamer: true,
      KeyboardInput:false,
      MouseInput:false,
      HoveringMouseMode:true,
      StreamerId:"Editor"
    }
  });
  pixelStreaming = new PixelStreaming(config, { videoElementParent: document.getElementById("midbox")});
}
export default {
  data(){
    return{

    }
  },
  methods:{

  }
}

</script>

<style>
#streamingVideo{
  object-fit: fill;
  margin: 0;
  padding: 0;
  z-index: -1;
}
</style>
