<template>
  <AppContainer >
    <NavSide/>
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
          </tr>
        </tbody>
      </table>
    </div>
  </AppContainer>
</template>

<script>

import AppContainer from '../components/container.vue';
import NavSide from '../components/nav_side.vue';

export default {
  name: 'HomeView',
  components: {
    AppContainer,
    NavSide
  },
  data(){
    return{
      a_1:'/a_1'
    }
  }
}



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
