# Project Plan
### Instructions:

1. We need to calculate calendar schedules for project plans
2. Each project plan consists of tasks. Every task has a certain duration.
3. A task can depend on zero or more other tasks. If a task depends on
   some other tasks, it can only be started after these tasks are completed
4. So, for a set of tasks (with durations and dependencies), the solution
   for the challenge should generate a schedule, i.e. assign Start and End
   Dates for every task
5. It is ok to have a console app
6. The solution should be pushed to GitHub

## Setup to run application

1. Open application.properties
   1.a Update postgres username, and password.
   1.b Update spring.datasource.url if you have different port for postgres.
2. Create new database with name: projectplan
   ``
   CREATE DATABASE projectplan;
   ``
3. Run the application by clicking the RUN button or simply [Shift] + [F10]

## API ENDPOINTS

###### GET ALL OF THE PROJECT PLANS
``
GET /api/project-plan
``
###### ADD NEW PROJECT PLAN
``POST /api/project-plan``
##### GET SCHEDULE FOR A SPECIFIC PROJECT PLAN
``GET /api/project-plan/{id}``
##### GET ALL TASKS
``GET /api/task``
##### ADD NEW TASK
``POST /api/task``
##### UPDATE STATUS FOR A TASK (DEPENDENCY CHECK)
``PATCH /api/task/{id}``
##### CALCULATE SCHEDULE / DURATION OF A PROJECT PLAN
``GET /api/project-plan/calculate-schedule/{id}``
##### CALCULATE SCHEDULE / DURATION OF ALL PROJECT PLANS
``GET /api/project-plan/calculate-schedules``

## Steps suggested to test
1. Create 2 ProjectPlans using api endpoint ``POST /api/project-plan``
- Query Paramater - name : ProjectPlan1
- Query Parameter - name : ProjectPlan2
2. Create 4 Tasks using api endpoint ``POST /api/task``
   Query Paramter
-                 taskname : Task1
-                 projectPlan : 1          (ID of the first project plan)
-                 startDate: 04/10/2022    (DD/MM/YYYY)
-                 endDate: 15/10/2022      (DD/MM/YYYY)
-                 status: COMPLETED      (Accepted values are (START, NOT_STARTED, & COMPLETED))
Query Paramter
-                 taskname : Task2
-                 projectPlan : 1          (ID of the first project plan)
-                 startDate: 03/10/2022    (DD/MM/YYYY)
-                 endDate: 10/10/2022      (DD/MM/YYYY)
-                 status: NOT_STARTED      (Accepted values are (START, NOT_STARTED, & COMPLETED))'
-                 dependency: 1
Query Paramter
-                 taskname : Task3
-                 projectPlan : 1          (ID of the first project plan)
-                 startDate: 06/10/2022    (DD/MM/YYYY)
-                 endDate: 14/10/2022      (DD/MM/YYYY)
-                 status: NOT_STARTED      (Accepted values are (START, NOT_STARTED, & COMPLETED))         
-                 dependency: 1,2
3. Test dependency check, use api ``PATCH /api/task/{id}``
- query parameter - status (Accepted values are (START, NOT_STARTED, & COMPLETED))
4. Test calculation of schedule/duration of project plan, use apis ``GET /api/project-plan/calculate-schedules`` and
   ``GET /api/project-plan/calculate-schedule/{id}``