function html(){
function showOutput(text){
document.getElementById("output").innerHTML= text
}
function loadData() {
fetch('/players')
  .then((response) => {
    return response.json();
  })
  .then((data) => {
  showOutput(JSON.stringify(data, null, 2));
  }).catch(err=>{
  showOutput( "Failed: " + err );});
}
function addPlayer(){
var name= document.getElementById("email").value
if(name){
console.log(name)
postPlayer(name)
}
}
function postPlayer(name){
fetch('/players', {
  method: 'POST', // or 'PUT'
  headers: {
    'Content-Type': 'application/json',
  },
  dataType: "text",
  body: JSON.stringify({ "userName": name }),
})
.then((response) => response.json())
.then((data) => {
  showOutput( "Saved – reloading");
  loadData();
})
.catch((error) => {
  console.error('Error:', error);
});
}
document.getElementById("add_player").addEventListener("click", ()=>{addPlayer()})
loadData();
}
html()