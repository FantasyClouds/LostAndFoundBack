<template>
  <AppContainer >
    <NavSide />
    <div class="about">
      <h1>未完待续……</h1>
    </div>
  </AppContainer>

</template>

<script>
import AppContainer from '../components/container.vue';
import NavSide from '../components/nav_side.vue';

export default {
  name: "AboutView",
  components: {
    AppContainer,
    NavSide
  }
};
</script>

<style>
  .about {
    margin: 0 auto;
  }
</style>


