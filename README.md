# Ride-Sharing Platform Backend API

## Challenge: Design a API for a Ride-Sharing Platform

### Problem Statement
This project involves designing a backend API for a ride-sharing platform. The platform must support multiple entities and complex relationships, including:

- **Users**: Riders and Drivers.
- **Rides**: Details include start and end locations, fare, and timestamps.
- **Vehicles**: Each driver has a registered vehicle.
- **Payments**: Payments can be split between multiple riders in shared rides.
- **Ratings**: Riders rate drivers, and drivers rate riders.

---

### Requirements

#### API Endpoints

1. **User Management**
   - Create a new user (Rider or Driver)
   - Update user details
   - Delete a user

2. **Ride Booking**
   - Book a ride (single or shared)
   - Cancel a ride
   - View ride history

3. **Driver Assignment**
   - Assign a driver to a ride
   - Mark a ride as completed

4. **Payments**
   - Record payment details
   - Split payment among riders in shared rides

5. **Ratings**
   - Submit ratings for riders and drivers
   - Fetch ratings for a specific user (Rider or Driver)

---

### Database Relationships

- **Users**:
  - Each user has a role: Rider or Driver.

- **Drivers and Vehicles**:
  - A driver can register multiple vehicles but have only one active vehicle at a time.

- **Rides**:
  - A ride can involve multiple riders (for shared rides) but only one driver.

- **Payments**:
  - Payments are associated with specific rides and riders.

- **Ratings**:
  - Ratings are linked to both rides and users.



---

### Additional Considerations

- **Error Handling**:
  - Graceful error responses for invalid requests.

- **Scalability**:
  - Use caching (e.g., Redis) for frequently accessed data.
  - Implement database sharding for large datasets.

- **Security**:
  - Secure sensitive information (e.g., user passwords) with encryption.
  - Implement rate limiting to prevent abuse.

- **Testing**:
  - Unit tests for individual components.
  - Integration tests for API endpoints.

---


