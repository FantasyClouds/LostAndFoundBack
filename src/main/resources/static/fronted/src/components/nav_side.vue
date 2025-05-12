<template>
  <div class="navSide">
    <nav>
      <ColumnList>
        <NavItem >

        </NavItem>
      </ColumnList>
      <ul class="navList">
        <li>
          <div class="navBox">
            <router-link to="/">主页</router-link>
          </div>
        </li>
        <li>
          <div class="navBox">
            <router-link to="/about">关于</router-link>
          </div>
        </li>
      </ul>
    </nav>
  </div>
</template>

<script>
import ColumnList from '../components/column_list.vue';
import NavItem from '../components/nav_item.vue';

  export default {
    name: 'NavSide',
    components: {
      ColumnList,
      NavItem
    }
  }
  
</script>

<style>
  *{
    padding: 0;
    margin: 0;
  }
  .navSide {
    width: 150px;
    box-sizing: border-box;
    background-color: #f4f4f4;
  }
  .navBox{
    width: 100%;
    height: 50px;
    line-height: 50px;
    text-align: center;
    color: #00fbff;
    cursor: pointer;
    font-size: larger;
  }
  ul{
    padding: 0;
    margin: 0;
    list-style: none;
  }
</style>