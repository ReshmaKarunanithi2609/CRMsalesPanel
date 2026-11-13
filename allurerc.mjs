// Allure 3 config. NOTE: "results" is NOT a config field any more - the results folder is passed
// on the command line:  npx allure generate allure-results
export default {
    name: "CRM Mobile Automation Report",
    output: "./allure-report",
    plugins: {
        awesome: {
            options: {
                singleFile: true   // one self-contained index.html, opens by double click
            }
        }
    }
};
