import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {SongService} from '../service/song.service';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'app-youtube-player',
  templateUrl: './youtube-player.component.html',
  styleUrls: ['./youtube-player.component.css']
})
export class YoutubePlayerComponent implements OnInit {
  song: any;
  // tslint:disable-next-line:variable-name
  constructor(private _activatedRoute: ActivatedRoute, private songService: SongService, private domSanitizer: DomSanitizer) { }

  ngOnInit(): void {
    const id = this._activatedRoute.snapshot.paramMap.get('id');
    this.song = this.songService.findSongById(id);
  }
  getSrc() {
    const url = 'https://www.youtube.com/embed/' + this.song.id;
    return this.domSanitizer.bypassSecurityTrustResourceUrl(url);
  }
}
