/*
 * Copyright 2015 Eze Chibuzo.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package database;

public enum StaffTable {

    STAFF_ID("staff_id"),
    FNAME("fname"),
    LNAME("lname"),
    OTHER_NAMES("other_names"),
    EMAIL("email"),
    MARRITAL_STATUS("marrital_status"),
    PICTURE("picture"),
    BANK("bank"),
    ACCOUNT_NO("account_no"),
    DATE_JOINED("date_joined"),
    SEX("sex"),
    RESIDENTIAL_ADDRESS("residential_address"),
    PERMANENT_ADDRESS("permanent_address"),
    NEXT_OF_KIN("next_of_kin"),
    PHONE("phone"),
    SALARY_TO_DATE("salary_to_date"),
    DEPARTMENT_ID("department_id"),
    DESIGNATION("designation"),
    LAST_MATERNITY_DATE("last_maternity_date"),
    LEAVE_DATE("leave_date");

    private final String name;

    StaffTable(String tableName) {
        name = tableName;
    }

    @Override
    public String toString() {
        return name;
    }
}
