let jsonData;
	
	
function fetchData() {
	fetch('JsonController', {
        method: 'POST'
	 })
	 .then(response => response.json())
	 .then(data => {
	    console.log(data);
	    jsonData = data;
	
	    // Call function to calculate gender counts and create chart
	    displayGenderChart();
	    displayStatusChart();
	    displayWifiServiceChart();
	 })
	 .catch(error => console.error('Error fetching data:', error));
}
	    
fetchData();
	
function countByGender(data) {
	const counts = {
	    male: 0,
	    female: 0
	};
	
	data.forEach(record => {
	    if (record.gender === "Male") {
	        counts.male++;
	    } else if (record.gender === "Female") {
	          counts.female++;
	    }
	});
	
	return counts;
}
	    
function countByStatus(data) {
    const counts = {
        "Highly  dissatisfied": 0,
        "Dissatisfied": 0,
        "Neutral": 0,
        "Satisfied": 0,
        "Highly satisfied": 0
    };

    data.forEach(record => {
        const status = record.status;
        if (status in counts) {
            counts[status]++;
        }
    });

    return counts;
}


function countByWifiService(data) {
    const counts = {};
    
    // Initialize counts for each possible wifi_service value
    for (let i = 1; i <= 7; i++) {
        counts[i] = 0;
    }

    data.forEach(record => {
        const wifiService = record.wifi_service;
        if (wifiService in counts) {
            counts[wifiService]++;
        }
    });

    return counts;
}

function countByOnlineBooking(data) {
    const counts = {};
    
    // Initialize counts for each possible online_booking value
    for (let i = 1; i <= 7; i++) {
        counts[i] = 0;
    }

    data.forEach(record => {
        const onlineBooking = record.online_booking;
        if (onlineBooking in counts) {
            counts[onlineBooking]++;
        }
    });

    return counts;
}


// Charts	
function displayGenderChart() {
	const genderCounts = countByGender(jsonData);
	console.log(genderCounts);
	
	const ctx = document.getElementById('genderChart').getContext('2d');
	const genderChart = new Chart(ctx, {
	    type: 'bar',
	    data: {
	        labels: ['Male', 'Female'],
	            datasets: [{
	                label: 'Gender Distribution',
	                data: [genderCounts.male, genderCounts.female],
	                backgroundColor: [
	                    'rgba(54, 162, 235, 0.2)', // Blue for Male
	                    'rgba(255, 99, 132, 0.2)' // Red for Female
	                ],
	                borderColor: [
	                    'rgba(54, 162, 235, 1)',
	                    'rgba(255, 99, 132, 1)'
	                ],
	                borderWidth: 1
	            }]
	        },
	        options: {
	            scales: {
	                y: {
	                    beginAtZero: true
	                 }
	            }
	        }
	});
}


function displayStatusChart() {
    const statusCounts = countByStatus(jsonData);
    console.log(statusCounts);

    const ctx = document.getElementById('statusChart').getContext('2d');
    const statusChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: Object.keys(statusCounts),
            datasets: [{
                label: 'Status Distribution',
                data: Object.values(statusCounts),
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)', // Red for Highly dissatisfied
                    'rgba(255, 159, 64, 0.2)', // Orange for Dissatisfied
                    'rgba(255, 205, 86, 0.2)', // Yellow for Neutral
                    'rgba(75, 192, 192, 0.2)', // Green for Satisfied
                    'rgba(54, 162, 235, 0.2)' // Blue for Highly satisfied
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(255, 159, 64, 1)',
                    'rgba(255, 205, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(54, 162, 235, 1)'
                ],
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}

function displayWifiServiceChart() {
    const wifiServiceCounts = countByWifiService(jsonData);
    console.log(wifiServiceCounts);

    const ctx = document.getElementById('wifiServiceChart').getContext('2d');
    const wifiServiceChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: Object.keys(wifiServiceCounts),
            datasets: [{
                label: 'Wifi Service Distribution',
                data: Object.values(wifiServiceCounts),
                backgroundColor: 'rgba(75, 192, 192, 0.2)', // Green color
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}

function displayOnlineBookingChart() {
    const onlineBookingCounts = countByOnlineBooking(jsonData);
    console.log(onlineBookingCounts);

    const ctx = document.getElementById('onlineBookingChart').getContext('2d');
    const onlineBookingChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: Object.keys(onlineBookingCounts),
            datasets: [{
                label: 'Online Booking Distribution',
                data: Object.values(onlineBookingCounts),
                backgroundColor: 'rgba(255, 206, 86, 0.2)', // Yellow color
                borderColor: 'rgba(255, 206, 86, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}
