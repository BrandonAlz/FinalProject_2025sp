import com.amazonaws.AmazonServiceException;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
package Dynomite;

public class CreateUser {

    private static final String TABLE_NAME = "GameUsers"; 
    private static final String USER_ID_ATTRIBUTE = "userId";
    private static final String USERNAME_ATTRIBUTE = "username";
    private static final String EMAIL_ATTRIBUTE = "email";
    private static final String CHARACTER_PROTOTYPE_ATTRIBUTE = "characterPrototype";
    private static final String name;
    private static final int health;
    private static final int maxHealth;
    private static final int damage;
    private static final int energy;
    private static final int maxEnergy;
    private static final List<Ability> abilities;

    public static void main(String[] args) {
       
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion(Regions.US_EAST_1) 
                .build();

        // Create a new user's data
        String userId = UUID.randomUUID().toString();
        String username = "PlayerOne";
        String email = "player1@example.com";
        String characterPrototype = "Warrior";

        
        Map<String, AttributeValue> item = new HashMap<>();
        item.put(USER_ID_ATTRIBUTE, new AttributeValue().withS(userId));
        item.put(USERNAME_ATTRIBUTE, new AttributeValue().withS(username));
        item.put(EMAIL_ATTRIBUTE, new AttributeValue().withS(email));
        item.put(CHARACTER_PROTOTYPE_ATTRIBUTE, new AttributeValue().withS(characterPrototype));
        // Add other attributes
      

     
        PutItemRequest putItemRequest = new PutItemRequest()
                .withTableName(TABLE_NAME)
                .withItem(item);

        try {
          
            PutItemResult result = client.putItem(putItemRequest);
            System.out.println("Successfully added user: " + userId);
            System.out.println("PutItem Result: " + result);

        } catch (AmazonServiceException e) {
            System.err.println("Error adding user: " + e.getMessage());
        } finally {
            // Optional: close
            
        }
    }
}
