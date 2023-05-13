
const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/TenantsProfile.vue') },
      { path: '/tenants', component: () => import('pages/TenantsProfile.vue') },
      { path: '/unitType', component: () => import('pages/UnitType.vue') },
      { path: '/collectibleList', component: () => import('pages/CollectibleList.vue') },
      { path: '/aboutUs', component: () => import('pages/AboutUs.vue') },
      { path: '/dashboardPage', component: () => import('pages/DashboardPage.vue') }
    ]
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue')
  }
]

export default routes
