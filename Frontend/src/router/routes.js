
const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/Index.vue'), meta: { requiredRole: "*" } },
    ],

  },
  {
    path: '/account',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', name: "Login", component: () => import('pages/Login.vue') }
    ]
  },
{
    path: '/user',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', name: "User", component: () => import('pages/User.vue') }
    ]
  },
  {
    path: '/home',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', name: "Dashboard", component: () => import('pages/Dashboard.vue') }
    ]
  },
  {
    path: '/task',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', name: "Task", component: () => import('pages/Task.vue') }
    ]
  },
  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/Error404.vue')
  }
]

export default routes
