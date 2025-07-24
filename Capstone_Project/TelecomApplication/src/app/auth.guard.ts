import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

export const authGuard: CanActivateFn = (route) => {
  const router = inject(Router);
  const userType = localStorage.getItem('userType');

  // if (route.data['role'] === userType) {
  //   return true; 
  // }
  if (Array.isArray(route.data['role']) && route.data['role'].includes(userType)) {
    return true; 
  }
  if (route.url[0].path === 'employee' || route.url[0].path === 'project') {
    if (userType !== 'admin') {
      router.navigate(['/login']);
      return false;
    }
  }
  if (route.data['role'] === userType) {
    return true;
  }
  router.navigate(['/login']);
  return false;
};
