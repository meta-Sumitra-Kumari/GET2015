$(document).ready(init);

function init(){
   $("#startBtn").click(function(){
       $("div").animate({left: "+=500px" ,  opacity: '1.0'}, 400);
   });

$("#stopBtn").click(function(){
       $("div").stop();
   });

$("#backBtn").click(function(){

       $("div").animate({left: '-=500px',  opacity: '0.5'}, 400);
   });

$("#leftBtn").click(function(){
       $("div").animate({left: '-=50px' ,  opacity: '0.75'} , "slow");
   });

$("#rightBtn").click(function(){
       $("div").animate({left: '+=50px' ,  opacity: '0.25'}, "slow");
   });

$("#topBtn").click(function(){
       $("div").animate({top: '-=50px' ,  opacity: '0.75'}, "slow");
   });

$("#bottomBtn").click(function(){
       $("div").animate({top: '+=50px' ,  opacity: '0.25'}, "slow");
   });
}