const routes = [{
        path: '/',
        component: () =>
            import ('layouts/MainLayout.vue'),
        children: [{
            path: '',
            component: () =>
                import ('pages/Index.vue'),
            meta: { requiredRole: "*" }
        }, ],

    },
    {
        path: '/user',
        component: () =>
            import ('layouts/MainLayout.vue'),
        children: [{
            path: '',
            name: "User",
            component: () =>
                import ('pages/User.vue')
        }]
    },
    {
        path: '/home',
        component: () =>
            import ('layouts/MainLayout.vue'),
        children: [{
            path: '',
            name: "Dashboard",
            component: () =>
                import ('pages/Dashboard.vue')
        }]
    },
    {
        path: '/task',
        component: () =>
            import ('layouts/MainLayout.vue'),
        children: [{
            path: '',
            name: "Task",
            component: () =>
                import ('pages/Task.vue')
        }]
    },
    {
        path: '/register',
        component: () =>
            import ('layouts/MainLayout.vue'),
        children: [{
            path: '',
            name: "Register",
            component: () =>
                import ('pages/Register.vue')
        }]
    },
    {
        path: '/edit',
        component: () =>
            import ('layouts/MainLayout.vue'),
        children: [{
            path: '',
            name: "Task",
            component: () =>
                import ('pages/UserEdit.vue')
        }]
    },
    // Always leave this as last one,
    // but you can also remove it
    {
        path: '/:catchAll(.*)*',
        component: () =>
            import ('pages/Error404.vue')
    }
]

export default routes