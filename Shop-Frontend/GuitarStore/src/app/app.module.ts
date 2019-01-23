import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { ElectricComponent } from './electric/electric.component';
import { BassComponent } from './bass/bass.component';
import { ClassicComponent } from './classic/classic.component';
import { AdminPanelComponent } from './admin-panel/admin-panel.component';
import {routing} from './app.routing';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {HttpModule} from '@angular/http';
import {FormsModule} from '@angular/forms';
import { AcousticComponent } from './acoustic/acoustic.component';
import { ContactComponent } from './contact/contact.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { ChartsModule } from 'ng2-charts';
import { FavouritesComponent } from './favourites/favourites.component';
import { SearchComponent } from './search/search.component';
import {AuthInterceptor} from './interceptors/auth.service';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LandingPageComponent,
    ElectricComponent,
    BassComponent,
    ClassicComponent,
    AdminPanelComponent,
    AcousticComponent,
    ContactComponent,
    LoginComponent,
    RegisterComponent,
    ShoppingCartComponent,
    FavouritesComponent,
    SearchComponent,

  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    routing,
    HttpClientModule,
    HttpModule,
    FormsModule,
    ChartsModule
  ],
  providers: [{
   provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
