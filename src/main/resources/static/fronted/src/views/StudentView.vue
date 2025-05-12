<template>
    <div class="common-layout">
      <el-container>
        <el-header class="header_color">教务系统学生管理</el-header>
        <el-container>
          <el-row class="tac">
          <!--以下是侧边栏-->
            <el-menu
              active-text-color="#04111C"
              background-color="#F5DEB3"
              class="el-menu-vertical-demo"
              default-active="2"
              text-color="#04111C"
              @open="handleOpen"
              @close="handleClose"
              @select="selectFunc"
              :unique-opened="true"
            >
              <el-sub-menu index="1">
                <template #title>
                  <el-icon><location /></el-icon>
                  <span>七年级</span>
                </template>
                  <el-menu-item index="1-1">一班</el-menu-item>
                  <el-menu-item index="1-2">二班</el-menu-item>
              </el-sub-menu>
              <el-sub-menu index="2">
                <template #title>
                  <el-icon><location /></el-icon>
                  <span>八年级</span>
                </template>
                  <el-menu-item index="2-1">一班</el-menu-item>
                  <el-menu-item index="2-2">二班</el-menu-item>
              </el-sub-menu>
              <el-sub-menu index="3">
                <template #title>
                  <el-icon><location /></el-icon>
                  <span>九年级</span>
                </template>
                  <el-menu-item index="3-1">一班</el-menu-item>
                  <el-menu-item index="3-2">二班</el-menu-item>
              </el-sub-menu>
            </el-menu>
          </el-row>
          <!--以下是主体-->
          <el-container>
            <!--以下是头部-->
            <el-header height="80px" style="padding: 0;margin: 0;">
              <el-container class="subHeader">
                <div class="desc">{{ desc }}</div>
                <el-button style="width:100px;height:30px;margin:20px" @click="dialogStudent = true">新增记录</el-button>
                <el-button style="width:100px;height:30px;margin:20px" @click="deleteStudent">删除</el-button>
              </el-container>
            </el-header>
            <!--以下是中部-->
            <el-main>
              <div class="content" >
                <el-table :data="stuShow" @selection-change="selected" style="width: 100%">
                  <el-table-column type="selection"/>
                  <el-table-column prop="id" label="学号" width="180" />
                  <el-table-column prop="name" label="姓名" width="180" />
                  <el-table-column prop="age" label="年龄" width="180" />
                  <el-table-column prop="sex" label="性别" width="180"/>
                  <el-table-column prop="time" label="录入时间"/>
                </el-table>
              </div>
            </el-main>
            <el-footer class="footer" height="30px">
              Vue框架搭建，ElementPlus提供组件支持
            </el-footer>
          </el-container>
          <!--以下是提交对话框-->
          <el-dialog v-model="dialogStudent" title="添加信息" width="500">
            <el-form :model="form">
              <!--
              <el-form-item label="学号" :label-width="formLabelWidth">
                <el-input v-model.number="form.id" autocomplete="off" />
              </el-form-item>
              -->
              <el-form-item label="姓名" :label-width="formLabelWidth">
                <el-input v-model="form.name" autocomplete="off" />
              </el-form-item>
              <el-form-item label="年龄" :label-width="formLabelWidth">
                <el-input v-model.number="form.age" autocomplete="off" />
              </el-form-item>
              <el-form-item label="性别" :label-width="formLabelWidth">
                <el-radio-group v-model="form.sex">
                  <el-radio value="男">男</el-radio>
                  <el-radio value="女">女</el-radio>
                </el-radio-group>
              </el-form-item>
              <el-form-item label="录入时间" :label-width="formLabelWidth">
                <div class="block">
                  <span class="demonstration">Default</span>
                  <el-date-picker
                    v-model="time"
                    type="datetime"
                    placeholder="Select date and time"
                  />
                </div>
              </el-form-item>
            </el-form>
            <template #footer>
              <div class="dialog-footer">
                <el-button @click="dialogStudent = false">取消</el-button>
                <el-button type="primary" @click="addStudent()">
                  确认
                </el-button>
              </div>
            </template>
          </el-dialog>
        </el-container>
      </el-container>
    </div>
</template>

<script setup>
import {reactive, onMounted, ref} from 'vue'
import axios from 'axios'
//以下是提交表单数据：
let dialogStudent = ref(false)
const formLabelWidth = '120px'
const time = ref('')
let grade = 0
let classs = 0
const students = ref([])
//初始挂载数据
onMounted(() => {
    axios.get('http://localhost:8888/data/students').then((res) => {
      console.log("mounted", res.data.data)
      res.data.data.forEach((value) => {
        students.value.push(value)
      })
    })
  })

const form = reactive({
  name : '',
  age : '',
  sex : '',
})
//以下是表单逻辑处理：
const addStudent = () =>{
    console.log("addStudent")
    /*
    if(form.id == ''){
      alert("学号不能为空")
      return
    }
    else */if(form.name == ''){
      alert("姓名不能为空")
      return
    }
    else if(form.age == ''){
      alert("年龄不能为空")
      return
    }
    else if(form.sex == ''){
      alert("性别不能为空")
      return
    }
    else if(!ageJudge(form.age)){
      alert("年龄必须为正整数")
      return
    }/*
    else if(!idJudge(form.id)){
      alert("学号必须为正整数")
      return
    }*/
    else{
      dialogStudent.value = false
    }
    //提交
    axios.post('http://localhost:8888/data/studentsPost', {
      //id: form.id,
      name: form.name,
      age: form.age,
      sex: form.sex,
      time: time.value.toString(),
      grade: grade,
      classs: classs
    }).then((res) => {
      console.log("res:" + res.data.data)
      clearForm()
      if (res.data.code === 200) {
        dialogStudent.value = false
        if (res.data.data) {
          students.value.push(res.data.data) // 将新添加的学生添加到列表中
          selectFunc(`${grade - 6}-${classs}`)
        } else {
          console.error("后端返回的数据中没有 'data' 字段", res.data)
        }
      } else {
        console.error("添加学生失败，错误代码:", res.data.code)
      }
    }).catch((err) => {
      console.error("添加学生失败，错误信息:", err)
    })
  }
  //年龄判断
  function ageJudge(age){
    if(age < 0){
      return false
    }
    return true
  }
  //学号判断
  /*
  function idJudge(id){
    if(id == null || id == ""){
      return false
    }
    return true
  }
  */
  //清空表单
  const clearForm = () =>{
    //form.id = ''
    form.name = ''
    form.age = ''
    form.sex = ''
    form.time = ''
  }
  //以下是侧边栏逻辑处理：
  const desc = ref('7年级1班学生统计') 
  const stuShow = ref([])
  const selectFunc = (index) =>{
    console.log(index)
    let stuGrade = parseInt(index.charAt(0)) + 6 //转换为数值型
    grade = stuGrade
    let stuClass = parseInt(index.slice(2))
    classs = stuClass
    let stuFilter = students.value.filter((stu) => stu.grade === stuGrade && stu.classs === stuClass)
    console.log(stuFilter)
    stuShow.value = stuFilter//更新响应式数据
    desc.value = stuGrade + `年级${stuClass}班学生统计`//更新描述
  }

  //选中复选框
  let selectedArr = []
  const selected = (data)=>{
    selectedArr = data
    console.log("selected:", data)
  }

  const deleteStudent = () =>{
    console.log("deleteStudent")
    if(selectedArr.length == 0){
      alert("请先选择学生")
      return
    }
    axios.post('http://localhost:8888/data/studentsDelete', selectedArr).then((res) => {
      console.log("res:" + res.data.data)
      if (res.data.code === 200) {
        students.value = students.value.filter((stu) => !selectedArr.includes(stu)) // 更新列表
        selectedArr = []
        selectFunc(`${grade - 6}-${classs}`)
      } else {
        console.error("删除学生失败，错误代码:", res.data.code)
      }
    }).catch((err) => {
      console.error("删除学生失败，错误信息:", err)
    })
  }
</script>

<style>
  .a1 {
    margin: 0 auto;
    flex: 1;
  }
  .header_color {
    background-color: #F1F1F1;
    height: 80px;
    line-height: 80px;
    font-size: 40px;
  }
  .subHeader {
    background-color: #6495ED;
  }
  .desc{
    font-size: 25px;    
    line-height: 80px;
    color: white;
    width: 800px;
  }
  .content{
    height: 410px;
  }
  .footer{
    background-color: dimgray;
    color: white;
    font-size: 17px;
    line-height: 30px;
  }
  
</style>


