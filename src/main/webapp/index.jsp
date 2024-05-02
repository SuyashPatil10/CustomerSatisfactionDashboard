<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="./CSS/index.css">
</head>
<body>
	
	<nav>
        <h1>RoomStay</h1>

        <div class="links">
            <p><a href="#">Service</a></p>
            <p><a href="#" class="fetchDataBtn">Contact</a></p>
            <p><a href="feedback.jsp">Feedback</a></p>
            <%
            	ArrayList userInfo = (ArrayList) session.getAttribute("userInfo");
            	ArrayList adminInfo = (ArrayList) session.getAttribute("adminInfo");
            	if(userInfo != null) {
            %>
            <p>Hii, <%=userInfo.get(0) %></p>
            <%
            	}
            	else if(adminInfo != null) {
            %>
            <p><a href="dashboard.jsp">Dashboard</a></p>
            <p><%=adminInfo.get(0) %></p>
            <%
            	}
            	else{
            %>
            
            <p><a href="login.jsp">Login</a></p>
            <p><a href="register.jsp">Signup</a></p>
            <%
            	}
            %>
        </div>
    </nav>

    <div class="front-container">
        <div class="image">
            <img src="Images/front-view-1.jpg" alt="">
        </div>

        <div class="front-desc">
            <div class="desc">
                <h1>Find Your Best Room</h1>
                <p>
                    Lorem ipsum dolor, sit amet consectetur adipisicing elit. Doloremque rem iusto molestiae at,
                    dignissimos
                    iste repudiandae ipsam inventore? Repellendus, rerum fugiat! Voluptatem non laboriosam ab numquam
                    provident. Unde odio quo tenetur deleniti harum laboriosam!
                </p>
            </div>
        </div>
    </div>

    <div class="apartment-container">
        <div class="apt-text">
            <h1>Top 4 Apartments</h1>
            <p>Top 4 Apartments of our hotel to a affordable price</p>
        </div>
    </div>

    <div class="slider">
        <div class="slider-over">
            <div class="slide">
                <img src="Images/front-view-2.jpg" alt="">
                <div class="desc">
                    <p class="apt-name">Beautiful Escape</p>
                    <p class="feature">4 Guest | 2 Rooms | 2 Bathrooms</p>

                    <p class="price">$ 3029</p>
                </div>
            </div>

            <div class="slide">
                <img src="Images/hotel-pool-1.jpg" alt="">
                <div class="desc">
                    <p class="apt-name">Beautiful Escape</p>
                    <p class="feature">6 Guest | 3 Rooms | 2 Bathrooms</p>

                    <p class="price">$ 5599</p>
                </div>
            </div>

            <div class="slide">
                <img src="Images/hotel-pool-6.jpg" alt="">
                <div class="desc">
                    <p class="apt-name">Beautiful Escape</p>
                    <p class="feature">6 Guest | 3 Rooms | 2 Bathrooms</p>

                    <p class="price">$ 5999</p>
                </div>
            </div>

            <div class="slide">
                <img src="Images/hotel-pool-3.jpg" alt="">
                <div class="desc">
                    <p class="apt-name">Beautiful Escape</p>
                    <p class="feature">8 Guest | 4 Rooms | 3 Bathrooms</p>

                    <p class="price">$ 6299</p>
                </div>
            </div>
        </div>
    </div>

    <div class="service-container">
        <div class="service-header">
            <h1>Convinences of our Services</h1>
        </div>
        <div class="service-desc">
            Our accommodations cater to a diverse range of travelers, offering both daily and long-term stays to suit
            varying needs. Whether you're an individual seeking a short-term retreat, a family embarking on a memorable
            vacation, or a team in town for business, we provide comfortable and welcoming lodging options.
        </div>
    </div>

    <div class="service-icons">
        <div class="icons">
            <div class="icon-image">
                <img src="image-icon/apartment.png" alt="">
            </div>
            <p>Apartment</p>
        </div>

        <div class="icons">
            <div class="icon-image">
                <img src="image-icon/bedroom.png" alt="">
            </div>
            <p>Bedroom</p>
        </div>

        <div class="icons">
            <div class="icon-image">
                <img src="image-icon/kitchen.png" alt="">
            </div>
            <p>Kitchen</p>
        </div>

        <div class="icons">
            <div class="icon-image">
                <img src="image-icon/wifi.png" alt="">
            </div>
            <p>Wifi</p>
        </div>
    </div>

    <div class="grid-show">
        <div class="grid-area">
            <div class="hotel-offer" id="discount">
                <div class="discount-percent">
                    <p class="upto">Upto</p>
                    <h1 class="percent">50%</h1>
                    <p>Off on early booking</p>
                </div>

                <div class="room-discount">
                    <p class="upto">upto</p>
                    <h2>30%</h2>
                    <p>off on rooms</p>

                    <button>Book now</button>
                </div>
            </div>
            <div class="grid-image" id="first">
                <img src="Images/hotel-pool-4.jpg" alt="">
            </div>

            <div class="grid-image" id="second">
                <img src="Images/hotel-dinning-1.jpg" alt="">
            </div>

            <!-- <div class="grid-image" id="third">
                <img src="Images/hotel-food-1.jpg" alt="">
            </div> -->

            <div class="grid-image" id="fourth">
                <img src="Images/hotel-room-3.jpg" alt="">
            </div>

            <div class="grid-image" id="fifth">
                <img src="Images/hotel-room-2.jpg" alt="">
            </div>

            <div class="grid-image" id="sixth">
                <img src="Images/hotel-pool-5.jpg" alt="">
            </div>
        </div>
    </div>

    <div class="beach-apt">
        <div class="beach-apt-grid">
            <div class="beach-image" id="grid-image">
                <img src="Images/beach-apartment.jpg" alt="">
            </div>

            <div class="beach-desc" id="grid-desc">
                <h2>Beach Apartment</h2>

                <p>
                    Experience coastal living at our beachfront apartments, catering to all travelers' needs. Whether
                    seeking a short escape or a prolonged seaside stay, our panoramic ocean views and attentive service
                    ensure every guest feels at home. Ideal for solo adventurers, families, or business teams, we
                    promise unforgettable moments and personalized hospitality by the shore.
                </p>

                <button>view more</button>
            </div>
        </div>
    </div>

    <footer>
        <div class="foot">
            <div class="web-info">
                <h1>RoomStay</h1>
                <p>
                    Discover comfort and convenience at RoomStay Hotel, where every stay is an unforgettable experience.
                    With our array of well-appointed rooms and suites, we cater to every traveler's needs, whether
                    you're here for business or leisure.
                </p>
            </div>

            <div class="foot-links">
                <h3>Links</h3>

                <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Service</a></li>
                    <li><a href="#">Contact</a></li>
                    <li><a href="#">Feedback</a></li>
                    <li><a href="#">Sign in</a></li>
                </ul>
            </div>

            <div class="subscribe">
                <h3>Subscribe</h3>

                <div class="input">
                    <input type="text" placeholder="Email Address">
                    <i class="fa-solid fa-arrow-right-long"></i>
                </div>

                <p>mailmesuyashpatil@gmail.com</p>
                <p>+91 7385401008</p>

                <div class="social-links">
                    <a href="#"><i class="fa-brands fa-instagram"></i></a>
                    <a href="#"><i class="fa-brands fa-facebook-f"></i></a>
                    <a href="#"><i class="fa-brands fa-linkedin-in"></i></a>
                </div>
            </div>
        </div>
    </footer>


    <script src="https://kit.fontawesome.com/40962f4670.js" crossorigin="anonymous"></script>
    
    <script>
        document.querySelector(".fetchDataBtn").addEventListener("click", fetchData);

        function fetchData() {
            fetch('JsonController', {
                method: 'POST'
            })
            .then(response => response.json())
            .then(data => {
                console.log(data);
                // Do something with the received data
            })
            .catch(error => console.error('Error fetching data:', error));
        }
    </script>
	
</body>
</html>