package utils;

public enum SqlQueries {

    SELECT_LAST_NAMES("SELECT lastname FROM addressbook;");

    private String sqlQuery;

    public String getSqlQuery() {
        return sqlQuery;
    }

    SqlQueries(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }

}
