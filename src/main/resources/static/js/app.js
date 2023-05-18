/**
 * 
 
<script type="text/javascript">
const settings = {
    async: true,
    crossDomain: true,
    url: 'https://endlessmedicalapi1.p.rapidapi.com/UpdateFeature?name=%3CREQUIRED%3E&value=%3CREQUIRED%3E&SessionID=%3CREQUIRED%3E',
    method: 'POST',
    headers: {
        'X-RapidAPI-Key': '3c1fe96527mshf1a599531d3e26dp1724b4',
        'X-RapidAPI-Host': 'endlessmedicalapi1.p.rapidapi.com'
    }
};

$.ajax(settings).done(function (response) {
    // console.log(response);
    let news = document.getElementById("api-news");
    news.innerText = response
    news.innerHTML = response
});

</script>
*/
$.ajax(settings).done(function (response) {
	document.getElemetById("welcome-page");
	});