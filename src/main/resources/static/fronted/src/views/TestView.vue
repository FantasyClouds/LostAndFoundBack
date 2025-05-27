<template>
  <AMISRenderer :schema="schema" :locals="locals" />
  <div>
    混合使用
  </div>
</template>
<script setup>
import AMISRenderer from "@/components/AMISRenderer";
import { ref} from "vue";

const schema = {
  "type": "page",
  "body": {
    "type": "crud",
    "api": {
      "method": "get",
      "url": "http://localhost:8888/data/testForm",
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
            "level": "link",
            "actionType": "dialog",
            "dialog": {
              "title": "修改信息",
              "body": {
                "type": "form",
                "api": "http://localhost:8888/data/testForm/Alter/${Sno}",
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
                    "type": "input-text",
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
            "actionType": "dialog",
            "dialog" : {
              "title": "确认删除",
              "actions": [
                {
                  "label": "确定",
                  "type": "submit",
                  "primary": true,
                  "actionType": "ajax",
                  "api": "http://localhost:8888/data/testForm/studentDeleteAmis/${Sno}",
                  "confirmText": "确认删除选中项？",
                  "afterAction": {
                    "success": {
                      "type": "dialog",
                      "title": "删除成功",
                      "body": "删除操作成功",
                      "actions": [
                        {
                          "label": "确定",
                          "type": "button",
                          "actionType": "closeDialog"
                        }
                      ],
                      "icon": "success",
                      "closeOnEsc": true,
                      "closeOnClickOutside": true
                    },
                    "finally": {
                      "type": "reload",
                      "componentId": "crud"
                    }
                  }
                },
                {
                  "label": "取消",
                  "type": "button",
                  "actionType": "closeDialog"
                }
              ]
            },
            "level": "link",
            "className": "text-danger",
          }
        ]
      }
    ],
    "bulkActions": [
      {
        "label": "删除",
        "actionType": "ajax",
        "api": "http://localhost:8888/data/testForm/studentsDeleteAmis/${ids}",
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
                "type": "input-text",
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
};
const locals = ref();


</script>
