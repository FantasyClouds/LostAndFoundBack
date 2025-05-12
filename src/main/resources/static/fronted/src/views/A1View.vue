<template>
  <AppContainer >
    <NavSide />
    <div class="a1">
      这里是嵌套路由
      <nav>
        <div>
          <router-link to="/a_1/a_1_1">第一个</router-link> |
          <router-link to="/a_1/a_1_2">第二个</router-link> |
          <router-link to="/a_1/a_1_3">第三个</router-link> 
        </div>
      </nav>
    </div>

  </AppContainer>

</template>

<script>
import AppContainer from '../components/container.vue';
import NavSide from '../components/nav_side.vue';

export default {
  name: "A1View",
  components: {
    AppContainer,
    NavSide
  }
};
</script>

<style>
  .a1 {
    margin: 0 auto;
    flex: 1;
  }
</style>


