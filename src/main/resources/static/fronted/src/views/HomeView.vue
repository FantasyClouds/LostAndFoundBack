<template>
  <div class="home">
    <Container>
      <NavSide></NavSide>
      <div class="home-view">
        <img alt="Vue logo" src="../assets/logo.png">
        <h1>欢迎使用Vue.js</h1>
        <table class="table">
          <tbody>
            <tr>
              <td><router-link to="a_1"> 点击查看嵌套路由 </router-link> </td>
              <td><router-link to="a_2"> 点击查看编程式路由 </router-link> </td>
              <td><router-link to="a_3"> 点击 </router-link> </td>
            </tr>
            <tr>
              <td><router-link to="students"> 点击查看教务系统 </router-link> </td>
              <td><router-link to="file"> 点击提交文件 </router-link> </td>
            </tr>
          </tbody>
        </table>
      </div>
    </Container>
  </div>
</template>

<script lang="ts" setup>
import NavSide from '../components/nav_side.vue';
import Container from '../components/container.vue'
</script>

<style>
.home-view {
  flex : 1;
}
.table{
  margin: 0 auto;
}
.table td{
  padding: 20px;
}
</style>