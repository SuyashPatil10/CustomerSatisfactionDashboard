<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./CSS/feedback.css">
</head>
<body>

	<div class="outer-container">
        <div class="main-container">
            <div class="section-side">
                <h1>RoomStay</h1>

                <p>
                    Join us in crafting unforgettable moments - your feedback fuels our journey to excellence!
                </p>

                <div class="sections">
                    <h4>Sections</h4>
                    <p><span class="number-check">1</span> Personal Info.</p>
                    <p><span class="number-check">2</span> Service Rating</p>
                </div>
            </div>

            <div class="input-side">
                <h1>Feedback Form</h1>
                <div class="feed">
                    <form action="feedbackController" method="post">
                        <div class="pr-feed">
                            <h3>Personal Information</h3>

                            <div class="input">
                                <input type="text" placeholder="First name" name="first-name">
                                <input type="text" placeholder="Last name" name="last-name">
                            </div>

                            <div class="input three">
                                <input type="text" placeholder="Gender" name="gender">
                                <input type="text" placeholder="zip-code" name="zip">
                                <input type="text" placeholder="city" name="city">
                            </div>

                            <div class="input">
                                <input type="text" placeholder="State" name="state">
                                <input type="text" placeholder="Country" name="country">
                            </div>
                        </div>


                        <div class="pr-feed">
                            <h3>Hotel Review &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span>Rate between 0 to 7</span>
                            </h3>

                            <div class="input">
                                <div class="single-input">
                                    <label for="">Wifi Service</label>
                                    <input type="text" placeholder="wifi" name="wifi">
                                </div>

                                <div class="single-input">
                                    <label for="">Online Booking ease</label>
                                    <input type="text" placeholder="booking" name="online-booking">
                                </div>
                            </div>

                            <div class="input three">
                                <div class="single-input">
                                    <label for="">Food & Drink</label>
                                    <input type="text" placeholder="food" name="food">
                                </div>

                                <div class="single-input">
                                    <label for="">Stay comfort</label>
                                    <input type="text" placeholder="comfort" name="comfort">
                                </div>

                                <div class="single-input">
                                    <label for="">checkout Service</label>
                                    <input type="text" placeholder="checkout" name="checkout">
                                </div>
                            </div>

                            <div class="input">
                                <div class="single-input">
                                    <label for="">Cleaniness</label>
                                    <input type="text" placeholder="clean" name="clean">
                                </div>

                                <div class="single-input">
                                    <label for="">Other Services</label>
                                    <input type="text" placeholder="services" name="other">
                                </div>
                            </div>
                        </div>

                        <div class="pr-feed">
                            <h3>Your Overall review</h3>

                            <select name="" id="">
                                <option value="">Highly Dissatisfied</option>
                                <option value="">Dissatisfied</option>
                                <option value="">Neutral</option>
                                <option value="">Satisfied</option>
                                <option value="">Highly Satisfied</option>
                            </select>
                        </div>

                        <div class="submit">
                            <input type="submit" value="submit">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>


</body>
</html>