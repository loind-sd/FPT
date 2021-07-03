/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var slideIndex = 1;
var slides = document.getElementsByClassName("test");
var p = 1;

var inter = setInterval(autoPlay, 2000);

function plusSlides(n) {
    slideIndex += n;
    showSlides(slideIndex);
}

function currentSlide(n) {
    showSlides(slideIndex = n);
}

function showSlides(n) {
    var i;
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    if (n > slides.length) {
        slideIndex = 1;
    }
    if (n < 1) {
        slideIndex = slides.length;
    }
    slides[slideIndex - 1].style.display = "block";
}

function autoPlay() {
    showSlides(slideIndex);
    slideIndex++;
}

function pause() {
    p = 0 - p;
    console.log(p);
    if (p < 0) {
        clearInterval(inter);
    }
    else {
        inter = setInterval(autoPlay, 2000);
    }
}



