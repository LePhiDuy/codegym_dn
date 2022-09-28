import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  constructor() { }
  navbar = 'home';
  get showHome() {
    return this.navbar === 'home';
  }
  get showAddPage() {
    return this.navbar === 'add';
  }
  ngOnInit(): void {
  }
  toggleNavbar(navbar: string) {
    this.navbar = navbar;
  }
}
