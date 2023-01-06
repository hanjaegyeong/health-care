
function initUserInfo(){
    document.querySelector("#imgUserProfileImageUrl").setAttribute("src", sessionStorage.getItem("userProfileImageUrl"));
}

function destroyUserInfo(){
    sessionStorage.removeItem("userName");
    sessionStorage.removeItem("userProfileImageUrl");
}
