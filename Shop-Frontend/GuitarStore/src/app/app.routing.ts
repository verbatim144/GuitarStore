import {Routes, RouterModule} from '@angular/router';
import {ElectricComponent} from './electric/electric.component';
import {LandingPageComponent} from './landing-page/landing-page.component';
import {AcousticComponent} from './acoustic/acoustic.component';
import {AdminPanelComponent} from './admin-panel/admin-panel.component';
import {ClassicComponent} from './classic/classic.component';
import {BassComponent} from './bass/bass.component';
import {AccessoriesComponent} from './accessories/accessories.component';
import {ContactComponent} from './contact/contact.component';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';



const appRoutes: Routes = [
  { path: 'landing', component: LandingPageComponent },
  { path: 'electric', component: ElectricComponent},
  { path: 'acoustic', component: AcousticComponent},
  { path: 'admin', component: AdminPanelComponent},
  { path: 'classic', component: ClassicComponent},
  { path: 'bass', component: BassComponent},
  { path: 'accessories', component: AccessoriesComponent},
  { path: 'contact', component:ContactComponent},
  { path: 'login', component:LoginComponent},
  { path: 'register', component:RegisterComponent},

  // otherwise redirect to profile
  { path: '**', redirectTo: '/landing' }
];

export const routing = RouterModule.forRoot(appRoutes) ;
