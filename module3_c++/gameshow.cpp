//
// Created by linde on 10/26/2024.
//

#include <iostream>
#include <string>
#include <map>
#include <vector>

// Defines the question object used throughout program
struct Question {
    std::string subject;
    std::string question;
    std::string answer;
};

// Method to ask the user a question and ends the program if they get it wrong
void askQuestion(const Question& q) {
    std::string userAnswer;
    std::cout << q.question << "\nYour answer: ";
    std::getline(std::cin, userAnswer);

    if (userAnswer != q.answer) {
        std::cout << "Incorrect! Game over. Better luck next time.\n";
        exit(0);
    } else {
        std::cout << "Correct!\n";
    }
}

// My game program!
int main() {

    // Creates a map of Question objects for grades 1 to 5, each with 3 questions
    std::map<std::string, std::vector<Question>> questionsByGrade = {
        {"1st Grade", {{"Math","What is 2 + 2?", "4"}, {"Science","What planet do we live on?", "Earth"}, {"History","Who discovered America?", "Christopher Columbus"}}},
        {"2nd Grade", {{"Math","What is 5 x 5?", "25"}, {"Science","What gas do plants breathe in?", "Carbon Dioxide"}, {"History","What country gave the United States the Statue of Liberty as a gift?", "France"}}},
        {"3rd Grade", {{"Math","What is 12 / 4?", "3"}, {"Science","What is the boiling point of water in Celsius?", "100"}, {"History","Who was the first President of the United States?", "George Washington"}}},
        {"4th Grade", {{"Math","What is 144 divided by 12?", "12"}, {"Science","What is the chemical symbol for water?", "H2O"}, {"History","What ancient city in Italy was buried by a volcano in AD 79?", "Pompeii"}}},
        {"5th Grade", {{"Math","What is the square root of 81?", "9"}, {"Science","What process do plants use to make food?", "Photosynthesis"}, {"History","Who wrote the Declaration of Independence?", "Thomas Jefferson"}}}
    };

    // Looping through the questions by grade
    for (const auto& [grade, questions] : questionsByGrade) {
        std::cout << "\n--- " << grade << " ---\n";

        // copies the values from questions to a new List remainingQuestions to loop through
        std::vector<Question> remainingQuestions = questions;

        // Loops through the questions in remainingQuestions
        while (!remainingQuestions.empty()) {
            std::cout << "Choose a subject:\n";
            // display the remaining subjects for this grade's questions
            for (int i = 0; i < remainingQuestions.size(); ++i) {
                std::cout << i + 1 << ". " << remainingQuestions[i].subject << "\n";
            }

            // prompt user for subject and capture value entered
            int choice;
            std::cout << "Enter the number for your chosen subject : ";
            std::cin >> choice;
            std::cin.ignore();

            // make sure choice is valid - else continue will do next while loop
            if (choice < 1 || choice > remainingQuestions.size()) {
                std::cout << "Invalid choice. Try again.\n";
                continue;
            }

            // converts the user's choice from a 1-based index (where 1 is the first item) to a 0-based index
            int index = (choice - 1);
            // ask the selected subject's question
            askQuestion(remainingQuestions[index]);
            // remove the asked question from the remainingQuestions list
            remainingQuestions.erase(remainingQuestions.begin() + index);
        }

        // Output for when the user finishes a round or wins the game
        std::cout << "Congratulations! You've passed " << grade << "!\n";
    }

    std::cout << "You're as smart as a 5th grader! Congrats!\n";
    return 0;
}
