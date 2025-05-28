<template>
  <AMISRenderer :schema="schema" :locals="locals" />
</template>
<script setup>
import AMISRenderer from "@/components/AMISRenderer";
import { ref} from "vue";

const schema = {
  "type": "page",
  "body": {
    "type": "tabs",
    "tabs": [
      {
        "title": "学生信息",
        "body": [
          {
            "type": "form",
            "id": "searchForm",
            "wrapWithPanel": false,
            "mode": "inline",
            "body": [
              {
                "type": "input-text",
                "name": "Sno",
                "label": "学号"
              },
              {
                "type": "input-text",
                "name": "Sname",
                "label": "姓名"
              },
              {
                "type": "input-number",
                "name": "Sage",
                "label": "年龄"
              },
              {
                "type": "input-text",
                "name": "Ssex",
                "label": "性别"
              },
              {
                "type": "radios",
                "name": "Grade",
                "label": "年级",
                "options": [
                  {
                    "label": "7",
                    "value": "7"
                  },
                  {
                    "label": "8",
                    "value": "8"
                  },
                  {
                    "label": "9",
                    "value": "9"
                  }
                ]
              },
              {
                "type": "input-number",
                "name": "Classs",
                "label": "班级"
              },
              {
                "type": "button-group-select",
                "name": "type",
                "options": [
                  {
                    "label": "和",
                    "value": true
                  },
                  {
                    "label": "或",
                    "value": false
                  }
                ]
              },
              {
                "type": "button",
                "label": "查询",
                "level": "primary",
                "onEvent": {
                  "click": {
                    "actions":[
                      {
                        "actionType": "clear",
                        "componentId": "searchForm"
                      },
                      {
                        "actionType": "reload",
                        "componentId": "studentCrud",
                        "data": {
                          "sno": "${Sno}",
                          "sname": "${Sname}",
                          "sage": "${Sage}",
                          "ssex": "${Ssex}",
                          "grade": "${Grade}",
                          "classs": "${Classs}",
                          "isAnd": "${type}"
                        }
                      }
                    ]
                  }
                }
              },
              {
                "type": "button",
                "label": "重置",
                "level": "primary",
                "onEvent": {
                  "click": {
                    "actions": [
                      {
                        "actionType": "clear",
                        "componentId": "searchForm"
                      },
                      {
                        "actionType": "reload",
                        "componentId": "studentCrud",
                        "data": {
                          "sno": "${Sno}",
                          "sname": "${Sname}",
                          "sage": "${Sage}",
                          "ssex": "${Ssex}",
                          "grade": "${Grade}",
                          "classs": "${Classs}",
                          "isAnd": "${type}"
                        }
                      }
                    ]
                  }
                }   
              }
            ]
          },
          {
            "type": "crud",
            "id": "studentCrud",
            "api": {
              "method": "get",
              "url": "http://localhost:8888/data/testForm/search",
              "data": "${searchForm}"
            },
            "columns" : [
              {
                "name" : "Sno",
                "label" : "ID"
              },
              {
                "name" : "Sname",
                "label" : "姓名"
              },
              {
                "name" : "Sage",
                "label" : "年龄"
              },
              {
                "name" : "Ssex",
                "label" : "性别"
              },
              {
                "name" : "Grade",
                "label" : "年级"
              },
              {
                "name" : "Classs",
                "label" : "班级"
              },
              {
                "name" : "EnrollmentTime",
                "label" : "入学时间"
              },
              {
                "type": "operation",
                "label": "操作",
                "buttons": [
                  {
                    "label": "修改",
                    "type": "button",
                    "level": "primary",
                    "actionType": "dialog",
                    "dialog": {
                      "title": "修改信息",
                      "body": {
                        "type": "form",
                        "api": "http://localhost:8888/data/testForm/Alter/${StudentInternalId}",
                        "body": [
                          {
                            "type": "input-text",
                            "name": "Sno",
                            "label": "学号"
                          },
                          {
                            "type": "input-text",
                            "name": "Sname",
                            "label": "姓名"
                          },
                          {
                            "type": "input-number",
                            "name": "Sage",
                            "label": "年龄"
                          },
                          {
                            "type": "input-text",
                            "name": "Ssex",
                            "label": "性别"
                          },
                          {
                            "type" : "radios",
                            "name" : "Grade",
                            "label" : "年级",
                            "options" : [
                              {
                                "label" : "7",
                                "value" : "7"
                              },
                              {
                                "label" : "8",
                                "value" : "8"
                              },
                              {
                                "label" : "9",
                                "value" : "9"
                              }
                            ]
                          },
                          {
                            "type" : "input-number",
                            "name" : "Classs",
                            "label" : "班级"
                          },
                          {
                            "type" : "input-date",
                            "name" : "EnrollmentTime",
                            "label" : "入学时间"
                          }
                        ]
                      }
                    }
                  },
                  {
                    "label": "删除",
                    "type": "button", 
                    "level": "danger",
                    "actionType": "ajax",
                    "confirmText": "确认删除${Sname}？",
                    "confirmTitle": "删除",
                    "api": "http://localhost:8888/data/testForm/studentDeleteAmis/${Sno}"
                  },
                ]
              }
            ],
            "bulkActions": [
              {
                "label": "删除",
                "actionType": "ajax",
                "api": {
                  "method": "post",
                  "url": "http://localhost:8888/data/testForm/studentsDeleteAmis",
                  "data": {
                    "StudentInternalIds": {
                      "$crud": {
                        "ID" : "${sno}"
                      }
                    }
                  }
                },
                "confirmText": "确认删除选中项？"
              }
            ],
            "headerToolbar": [
              "bulkActions",
              {
                "label": "新增",
                "type": "button",
                "actionType": "dialog",
                "dialog": {
                  "title": "新增信息",
                  "body": {
                    "type": "form",
                    "api": "http://localhost:8888/data/testForm/Add/${Sno}",
                    "reload": "crud",
                    "closeDialogOnSubmit": true,
                    "body": [
                      {
                        "type": "input-text",
                        "name": "Sno",
                        "label": "学号"
                      },
                      {
                        "type": "input-text",
                        "name": "Sname",
                        "label": "姓名"
                      },
                      {
                        "type": "input-number",
                        "name": "Sage",
                        "label": "年龄"
                      },
                      {
                        "type": "input-text",
                        "name": "Ssex",
                        "label": "性别"
                      },
                      {
                        "type": "radios",
                        "name": "Grade",
                        "label": "年级",
                        "options": [
                          {
                            "label": "7",
                            "value": "7"
                          },
                          {
                            "label": "8",
                            "value": "8"
                          },
                          {
                            "label": "9",
                            "value": "9"
                          }
                        ]
                      },
                      {
                        "type": "input-number",
                        "name": "Classs",
                        "label": "班级"
                      },
                      {
                        "type": "input-date",
                        "name": "EnrollmentTime",
                        "label": "入学时间"
                      }
                    ]
                  }
                }
              }
            ]
          }
        ],
        
      },
      {
        "title": "课程表",
        "type": "crud"
      },
      {
        "title": "选课成绩表",
        "type": "crud"
      }
    ]
  }
};
const locals = ref();


</script>
