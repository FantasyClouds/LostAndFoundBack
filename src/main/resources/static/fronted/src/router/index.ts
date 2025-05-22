import { createRouter, createWebHashHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/about',
    name: 'about',
    component: () => import('../views/AboutView.vue')
  },
  {
    path : '/a_1',
    name : 'a_1',
    component: () => import('../views/A1View.vue'),
    children:[
      {
        path : 'a_1_1',
        name : 'a_1_1',
        component: () => import('../views/A11View.vue')
      },
      {
        path : 'a_1_2',
        name : 'a_1_2',
        component: () => import('../views/A12View.vue')
      },
      {
        path : 'a_1_3',
        name : 'a_1_3',
        component: () => import('../views/A13View.vue')
      }
    ]
  },
  {
    path : '/a_2',
    name : 'a_2',
    component: () => import('../views/A2View.vue')
  },
  {
    path : '/a_3',
    name : 'a_3',
    component: () => import('../views/A3View.vue')
  },
  {
    path : '/students',
    name : 'students',
    component: () => import('../views/StudentView.vue')
  },
  {
    path : '/file',
    name : 'file',
    component: () => import('../views/FileView.vue')
  },
  {
    path : '/test',
    name : 'test',
    component: () => import('../views/TestView.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
