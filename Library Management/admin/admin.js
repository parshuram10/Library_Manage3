$('.add-b').click(function(){
    $('.book-update').hide();
    $('.book-del').hide();
    $('.book-search').hide();
    $('.book-view').hide();
    $('.add-form').toggle();
});
$('.updat-b').click(function(){
    $('.add-form').hide();
    $('.book-del').hide();
    $('.book-search').hide();
    $('.book-view').hide();
    $('.book-update').toggle();
});
$('.del-b').click(function(){
    $('.add-form').hide();
    $('.book-update').hide();
    $('.book-search').hide();
    $('.book-view').hide();
    $('.book-del').toggle();
});
$('.search-b').click(function(){
    $('.add-form').hide();
    $('.book-update').hide();
    $('.book-del').hide();
    $('.book-view').hide();
    $('.book-search').toggle();
});
$('.view-b').click(function(){
    $('.add-form').hide();
    $('.book-update').hide();
    $('.book-del').hide();
    $('.book-search').hide();
    $('.book-view').toggle();
});


