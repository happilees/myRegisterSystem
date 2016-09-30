// JavaScript Document

var activePage = 1;
var pageCount = 0;
var imgWidth;
$(function() {
	window.addEventListener('load', loadWithTime);
	
	$('#right').click(function() {
		if(activePage < pageCount) {
			$('#lunbo_body').animate({"left" : -imgWidth * activePage}, 200);
			activePage ++;
			} else if(activePage >= pageCount) {
				$('#lunbo_body').animate({"left" : 0}, 200);
				activePage = 1;
				}
		});
	
	$('#left').click(function() {
		if(activePage > 1) {
			activePage -= 1;
			$('#lunbo_body').animate({"left" : -imgWidth * (activePage - 1)}, 200);
			} else if(activePage <= 1) {
				$('#lunbo_body').animate({"left" : -imgWidth * (pageCount - 1)}, 200);
				activePage = pageCount;
				}
		});
	});

function loadWithTime() {
	var aSize = $('#lunbo_body img').size();
	pageCount = aSize;
	imgWidth = $('#lunbo').width();
	$('#lunbo_body img').width(imgWidth);
	var bodyWidth = aSize * imgWidth;
	$('#lunbo_body').width(bodyWidth);
	}
