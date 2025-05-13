<template>
  <AppContainer >
    <NavSide />
    <div class="a4">
      <h1>文件上传</h1>
      <h2>点击上传文件</h2>
      <el-upload
        ref="uploadRef"
        class="upload-demo"
        action="http://localhost:8888/data/file"
        :auto-upload="false"
      >
        <template #trigger>
          <el-button type="primary">select file</el-button>
        </template>

        <el-button class="ml-3" type="success" @click="submitUpload">
          upload to server
        </el-button>

        <template #tip>
          <div class="el-upload__tip">
            jpg/png files with a size less than 500kb
          </div>
        </template>
      </el-upload>
    </div>
    </AppContainer>
</template>


<script lang='ts' setup>

import { ref } from 'vue'
import AppContainer from '../components/container.vue';
import NavSide from '../components/nav_side.vue';
import type { UploadInstance } from 'element-plus'

  const uploadRef = ref<UploadInstance>()
  const submitUpload = () => {
    if (uploadRef.value){
      console.log(uploadRef.value);
      uploadRef.value!.submit()
    }
  }

</script>


<style>
  .a4 {
    margin: 0 auto;
  }
</style>


