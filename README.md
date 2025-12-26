# help-service

## Quick Start

### Azure App Service

  - **Create a `Resource Group`:**

    ```sh
    az group create \
        --name <AZ_RG> \
        --location swedencentral
    ```

  - **Deploy the app to the `Azure App Service`:**
    ```sh
    gradle azureWebAppDeploy
    ```
    > **Note:** Ensure all required environment variables are configured for the azureWebAppDeploy task in the build.gradle file before running this command.

  - **Configure `logging` to `filesystem`:**

    ```sh
    az webapp log config \
        --application-logging filesystem \
        --name <AZ_WEBAPP> \
        --resource-group <AZ_RG>
    ```

  - **Download `logs` from running instance of the app:**

    ```sh
    az webapp log download \
        --name <AZ_WEBAPP> \
        --resource-group <AZ_RG>
    ```

  - **Delete running instance of the app:**

    ```sh
    az webapp delete \
        --name <AZ_WEBAPP> \
        --resource-group <AZ_RG>
    ```
  - **Clean up resources:**

    ```sh
    az group delete --name <AZ_RG>
    ```
