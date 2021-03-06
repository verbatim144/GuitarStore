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
import {ShoppingCartComponent} from './shopping-cart/shopping-cart.component';
import {FavouritesComponent} from './favourites/favourites.component';
import {SearchComponent} from './search/search.component';



const appRoutes: Routes = [
  { path: 'landing', component: LandingPageComponent },
  { path: 'electric', component: ElectricComponent},
  { path: 'acoustic', component: AcousticComponent},
  { path: 'admin', component: AdminPanelComponent},
  { path: 'classic', component: ClassicComponent},
  { path: 'bass', component: BassComponent},
  { path: 'contact', component:ContactComponent},
  { path: 'login', component:LoginComponent},
  { path: 'register', component:RegisterComponent},
  { path: 'cart', component:ShoppingCartComponent},
  { path: 'favourite', component:FavouritesComponent},
  { path: 'search', component:SearchComponent},

  // otherwise redirect to profile
  { path: '**', redirectTo: '/landing' }
];

export const routing = RouterModule.forRoot(appRoutes) ;
