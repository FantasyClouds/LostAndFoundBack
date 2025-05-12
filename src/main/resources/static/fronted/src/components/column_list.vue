<template>
  <div class="list">
    <slot>

    </slot>
  </div>
</template>

<script>
  export default {
    name: 'column-list'
  }
</script>

<style>
  *{
    margin: 0;
    padding: 0;
  }
  .list{
    display: flex;
    flex-direction: column;
    flex-wrap: nowrap;
    justify-content: flex-start;
    align-items: stretch;
  }
</style>