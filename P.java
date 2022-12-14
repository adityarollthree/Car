
      tags:
        - Vehicle
      summary: Retrieves list of user's vehicles
      description: >-
        The vehicles endpoint returns information about the user's registered
        vehicles. The response includes the vehicle id and other details about
        each vehicle.
      operationId: listVehicles
      produces:
        - application/json
      responses:
        '200':
          description: Successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Vehicle'
        '404':
          description: Vehicles not found
        default:
          description: Unexpected error
          schema:
            $ref: '#/definitions/Error'
      security:
        - cc-authorizer: []
    post:
      tags:
        - Vehicle
      summary: Creates a new vehicle for an owner
      description: >-
        The create vehicle endpoint creates an new registered vehicle for the
        owner. The response includes details about the newly registered vehicle
        for the owner.
      operationId: createVehicle
      produces:
        - application/json
      parameters:
        - name: Vehicle
          in: body
          description: Vehicle to register.
          required: true
          schema:
            $ref: '#/definitions/NewVehicle'
      responses:
        '200':
          description: Successful operation
          schema:
            $ref: '#/definitions/Vehicle'
        '401':
          description: Unauthorized to create vehicle
        default:
          description: Unexpected error
          schema:
            $ref: '#/definitions/Error'
      security:
        - cc-authorizer: []
  '/vehicles/{vin}':
    get:
      tags:
        - Vehicle
      summary: Retrieves a user's vehicle
      description: >-
        The vehicle endpoint returns information about a particular vehicle
        registered to a user. The response includes the vehicle id and other
        details about the vehicle.
      operationId: getVehicle
      produces:
        - application/json
      parameters:
        - in: path
          name: vin
          description: Vehicle Identification Number to filter anomalies
          required: true
          type: string
      responses:
        '200':
          description: Successful operation
          schema:
            $ref: '#/definitions/Vehicle'
        '404':
          description: Vehicle not found
        default:
          description: Unexpected error
          schema:
            $ref: '#/definitions/Error'
      security:
        - cc-authorizer: []
  '/vehicles/{vin}/anomalies':
    get:
      tags:
        - Anomalies
      summary: Retrieves list of anomalies for vehicle
      description: >-
        The vehicle anomalies endpoint returns information about a vehicles
        historical anomalies. The response includes the anomaly id and other
        details about each anomaly.
      operationId: listAnomaliesByVehicle
      produces:
        - application/json
      parameters:
        - in: path
          name: vin
          description: Vehicle Identification Number to filter anomalies
          required: true
          type: string
      responses:
        '200':
          description: Successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Anomaly'
        '404':
          description: Vehicle not found
        default:
          description: Unexpected error
          schema:
            $ref: '#/definitions/Error'
      security:
        - cc-authorizer: []
  '/vehicles/{vin}/anomalies/{anomaly_id}':
    get:
      tags:
        - Anomalies
      summary: Retrieves an anomaly for vehicle
      description: >-
        The vehicle anomaly endpoint returns information about a particular
        vehicles historical anomalies. The response includes the anomaly id and
        other details about the anomaly.
      operationId: getVehicleAnomaly
      produces:
        - application/json
      parameters:
        - in: path
          name: vin
          description: Vehicle Identification Number to filter anomalies
          required: true
          type: string
        - in: path
          name: anomaly_id
          description: Anomaly id to return
          required: true
          type: string
      responses:
        '200':
          description: Successful operation
          schema:
            $ref: '#/definitions/Anomaly'
        '400':
          description: Invalid Anomaly Id supplied
        '404':
          description: Vehicle not found
        default:
          description: Unexpected error
          schema:
            $ref: '#/definitions/Error'
      security:
        - cc-authorizer: []
  '/vehicles/{vin}/anomalies/{anomaly_id}/acknowledge':
    put:
      tags:
        - Anomalies
      summary: Acknowledges an anomaly for vehicle
      description: >-
        The vehicle anomaly acknowledge endpoint updates the acknowledged field
        for a particular vehicles historical anomaly. The response includes the
        updated details about the anomaly.
      operationId: acknowledgeVehicleAnomaly
      produces:
        - application/json
      parameters:
        - in: path
          name: vin
          description: Vehicle Identification Number to filter anomalies
          required: true
          type: string
        - in: path
          name: anomaly_id
          description: Anomaly id to return
          required: true
          type: string
      responses:
        '200':
          description: Successful operation
          schema:
            $ref: '#/definitions/Anomaly'
        '400':
          description: Invalid Anomaly Id supplied
        '404':
          description: Vehicle not found
        default:
          description: Unexpected error
          schema:
            $ref: '#/definitions/Error'
      security:
        - cc-authorizer: []
  '/vehicles/{vin}/dtc':
    get:
      tags:
        - DTC
      summary: Retrieves diagnostic trouble codes for vehicle
      description: >-
        The vehicle dtc list endpoint returns information about a vehicles
        historical diagnostic trouble codes. The response includes the dtc id
        and other details about each diagnostic trouble code.
      operationId: listDtcByVehicle
      produces:
        - application/json
      parameters:
        - in: path
          name: vin
          description: Vehicle Identification Number to filter diagnostic trouble codes
          required: true
          type: string
      responses:
        '200':
          description: Successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/DiagnosticTroubleCode'
        '404':
          description: Vehicle not found
        default:
          description: Unexpected error
          schema:
            $ref: '#/definitions/Error'
      security:
        - cc-authorizer: []
  '/vehicles/{vin}/dtc/{dtc_id}':
    get:
      tags:
        - DTC
      summary: Retrieves a dtc record for vehicle
      description: >-
        The vehicle dtc endpoint returns information about a particular vehicles
        historical diagnostic trouble code. The response includes the dtc id and
        other details about the diagnostic trouble code.
      operationId: getVehicleDtc
      produces:
        - application/json
      parameters:
        - in: path
          name: vin
          description: Vehicle Identification Number to filter diagnostic trouble codes
          required: true
          type: string
        - in: path
          name: dtc_id
          description: Dtc id to return
          required: true
          type: string
      responses:
        '200':
          description: Successful operation
          schema:
            $ref: '#/definitions/DiagnosticTroubleCode'
        '400':
          description: Invalid Dtc Id supplied
        '404':
          description: Vehicle not found
        default:
          description: Unexpected error
          schema:
            $ref: '#/definitions/Error'
      security:
        - cc-authorizer: []
  '/vehicles/{vin}/dtc/{dtc_id}/acknowledge':
    put:
      tags:
        - DTC
      summary: Acknowledges a diagnostic trouble code for vehicle
      description: >-
        The vehicle dtc acknowledge endpoint updates the acknowledged field for
        a particular vehicles historical dtc. The response includes the updated
        details about the diagnostic trouble code.
      operationId: acknowledgeVehicleDtc
      produces:
        - application/json
      parameters:
        - in: path
          name: vin
          description: Vehicle Identification Number to filter diagnostic trouble codes
          required: true
          type: string
        - in: path
          name: dtc_id
          description: DTC id to return
          required: true
          type: string
      responses:
        '200':
          description: Successful operation
          schema:
            $ref: '#/definitions/DiagnosticTroubleCode'
        '400':
          description: Invalid DTC Id supplied
        '404':
          description: Vehicle not found
        default:
          description: Unexpected error
          schema:
            $ref: '#/definitions/Error'
      security:
        - cc-authorizer: []
  '/vehicles/{vin}/trips':
    get:
      tags:
        - Trips
      summary: Retrieves aggregated trip data for vehicle
      description: >-
        The vehicle trips endpoint returns information about a vehicles
        historical trips. The response includes the trip id and other details
        about each vehicle historical trip.
      operationId: listTripsByVehicle
      produces:
        - application/json
      parameters:
        - in: path
          name: vin
          description: Vehicle Identification Number to filter trips
          required: true
          type: string
      responses:
        '200':
          description: Successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/Trip'
        '404':
          description: Vehicle not found
        default:
          description: Unexpected error
          schema:
            $ref: '#/definitions/Error'
      security:
        - cc-authorizer: []
  '/vehicles/{vin}/trips/{trip_id}':
    get:
      tags:
        - Trips
      summary: Retrieves a trip record for vehicle
      description: >-
        The vehicle trip endpoint returns information about a particular
        vehicles historical trip. The response includes the trip id and other
        details about the trip.
      operationId: getVehicleTrip
      produces:
        - application/json
      parameters:
        - in: path
          name: vin
          description: Vehicle Identification Number to filter trips
          required: true
          type: string
        - in: path
          name: trip_id
          description: Trip id to return
          required: true
          type: string
      responses:
        '200':
          description: Successful operation
          schema:
            $ref: '#/definitions/Trip'
        '400':
          description: Invalid Trip Id supplied
        '404':
          description: Vehicle not found
        default:
          description: Unexpected error
          schema:
            $ref: '#/definitions/Error'
      security:
        - cc-authorizer: []
  '/vehicles/{vin}/healthreports':
    get:
      tags:
        - Health Reports
      summary: Retrieves a list of health reports for vehicle
      description: >-
        The vehicle health report endpoint returns information about a vehicles
        historical health reports. The response includes the health report id
        and other details about each vehicle historical health report.
      operationId: listHealthReportsByVehicle
      produces:
        - application/json
      parameters:
        - in: path
          name: vin
          description: Vehicle Identification Number to filter trips
          required: true
          type: string
      responses:
        '200':
          description: Successful operation
          schema:
            type: array
            items:
              $ref: '#/definitions/HealthReport'
        '404':
          description: Vehicle not found
        default:
          description: Unexpected error
          schema:
            $ref: '#/definitions/Error'
      security:
        - cc-authorizer: []
  '/vehicles/{vin}/healthreports/{report_id}':
    get:
      tags:
        - Health Reports
      summary: Retrieves a health report record for vehicle
      description: >-
        The vehicle health report endpoint returns information about a
        particular vehicles historical health report. The response includes the
        health report id and other details about the vehicle health report.
      operationId: getVehicleHealthReport
      produces:
        - application/json
      parameters:
        - in: path
          name: vin
          description: Vehicle Identification Number to filter trips
          required: true
          type: string
        - in: path
          name: report_id
          description: Health report id to return
          required: true
          type: string
      responses:
        '200':
          description: Successful operation
          schema:
            $ref: '#/definitions/HealthReport'
        '400':
          description: Invalid Health Report Id supplied
        '404':
          description: Vehicle not found
        default:
          description: Unexpected error
          schema:
            $ref: '#/definitions/Error'
      security:
        - cc-authorizer: []
securityDefinitions:
  cc-authorizer:
    type: apiKey
    name: Authorization
    in: header
    x-amazon-apigateway-authtype: cognito_user_pools
    x-amazon-apigateway-authorizer:
      type: cognito_user_pools
definitions:
  ResolutionStep:
    type: object
    properties:
      id:
        type: string
        description: The identifier of the resolution step
      detail:
        type: string
        description: The details for the resolution step
  Anomaly:
    type: object
    properties:
      anomaly_id:
        type: string
        description: The unique identifier of the anomaly
      vin:
        type: string
        description: Vehicle Identification Number for the vehicle
      telemetric:
        type: string
        description: The telemetric where the anomaly occured
      value:
        type: number
        format: float
        description: The telemetric value when the anomaly occured
      anomaly_score:
        type: number
        format: double
        description: The telemetric where the anomaly occured
      acknowledged:
        type: string
        description: Flag indicating if the anomaly is acknowledged
      description:
        type: string
        description: Description of the identified anomaly
      identified_at:
        type: string
        description: The datetime the anomaly was identified.
      measured_at:
        type: string
        description: The measurement datetime of the anomaly.
      created_at:
        type: string
        description: The creation datetime of the anomaly.
  DiagnosticTroubleCode:
    type: object
    properties:
      dtc_id:
        type: string
        description: The unique identifier of the dtc
      vin:
        type: string
        description: Vehicle Identification Number for the vehicle
      dtc:
        type: string
        description: The diagnostic trouble code identifier triggered
      description:
        type: string
        description: Description of the triggered dtc
      steps:
        type: array
        items:
          $ref: '#/definitions/ResolutionStep'
      acknowledged:
        type: string
        description: Flag indicating if the anomaly is acknowledged
      triggered_at:
        type: string
        description: The measurement datetime of the anomaly.
      created_at:
        type: string
        description: The creation datetime of the anomaly.
  NewVehicle:
    type: object
    properties:
      vin:
        type: string
        description: Vehicle Identification Number for the vehicle
      nickname:
        type: string
        description: Nickname for vehicle by owner
  Vehicle:
    type: object
    properties:
      vin:
        type: string
        description: Vehicle Identification Number for the vehicle
      owner_id:
        type: string
        description: Unique user id for the vehicle owner
      nickname:
        type: string
        description: Nickname for vehicle by owner
      Odometer:
        type: number
        format: float
        description: Odometer reading for the vehicle
  Trip:
    type: object
    properties:
      trip_id:
        type: string
        description: Unique identification for the trip
      vin:
        type: string
        description: Vehicle Identification Number for the vehicle
      owner:
        type: string
        description: Unique user id for the vehicle owner
      vehicle_speed_mean:
        type: number
        format: float
        description: Mean vehicle speed for trip
      engine_speed_mean:
        type: number
        format: float
        description: Mean engine speed for trip
      torque_at_transmission_mean:
        type: number
        format: float
        description: Mean transmision torque for trip
      oil_temp_mean:
        type: number
        format: float
        description: Mean oil temperature for trip
      accelerator_pedal_position_mean:
        type: number
        format: float
        description: Mean accelerator position for trip
      brake_mean:
        type: number
        format: float
        description: Mean brake position for trip
      odometer:
        type: number
        format: float
        description: Odometer reading for trip
      fuel_consumed_since_restart:
        type: number
        format: float
        description: Fuel consumed during trip
      fuel_level:
        type: number
        format: float
        description: Fuel level after trip
      start_latitude:
        type: number
        format: float
        description: Latitude at the beginning of the trip
      start_longitude:
        type: number
        format: float
        description: Longitude at the beginning of the trip
      stop_latitude:
        type: number
        format: float
        description: Latitude at the end of the trip
      stop_longitude:
        type: number
        format: float
        description: Longitude at the end of the trip
      start_time:
        type: string
        description: The start time of the trip.
      end_time:
        type: string
        description: The end time of the trip.
      driver_safety_score:
        type: number
        format: float
        description: Driver score for the trip
  HealthReport:
    type: object
    properties:
      report_id:
        type: string
        description: Unique identification for the health report
      vin:
        type: string
        description: Vehicle Identification Number for the vehicle
      owner_id:
        type: string
        description: Unique user id for the vehicle owner
  Error:
    type: object
    properties:
      code:
        type: integer
        format: int32
      message:
        type: string
