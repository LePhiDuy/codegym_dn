import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {TimelinesComponent} from './timelines/timelines.component';
import {YoutubePlaylistComponent} from './youtube-playlist/youtube-playlist.component';
import {YoutubePlayerComponent} from './youtube-player/youtube-player.component';

const routes: Routes = [
  {path: '',
  redirectTo: 'timelines',
  pathMatch: 'full'},
  {
    path: 'timelines',
    component: TimelinesComponent
  },
  {
    path: 'song',
    component: YoutubePlaylistComponent
  },
  {
    path: 'song/:id',
    component: YoutubePlayerComponent
  }
];


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes),
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
