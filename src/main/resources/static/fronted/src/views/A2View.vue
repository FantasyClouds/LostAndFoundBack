<template>
  <AppContainer >
    <NavSide />
    <div class="a2">
      编程式路由
      <nav>
        <div>
          <button @click = "$router.push('/')">首页</button>
          <button @click = "$router.push('/a_1')">嵌套路由页面</button>
          <button @click = "$router.push('/about')">About</button>
          <br>
          <button @click = "$router.forward()">前进</button>
          <button @click = "$router.back()">回退</button>
          <br>
          <br>
          <input type="text" class="text" v-model="msg">
          <router-link :to = "{name: 'a_3', query: {msg: msg}}"> 点击提交并跳转到A3页面</router-link>
        </div>
      </nav>
    </div>
  </AppContainer>

</template>

<script setup>
import {ref} from 'vue';
import AppContainer from '../components/container.vue';
import NavSide from '../components/nav_side.vue';


const msg = ref('');


</script>


<style>
  .a2 {
    margin: 0 auto;
  }
</style>


