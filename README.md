# ATM Interface

This Java program simulates a simple ATM interface that allows users to create accounts, sign in, and perform transactions, such as withdrawals, deposits, balance checks, and viewing bank statements. Account data is stored in text files, named after each user, to persist their balance and transaction history.

## Features

1. **Sign Up**: Allows a new user to create an account by entering a username and password.
2. **Sign In**: Enables existing users to log in using their username and password.
3. **Withdrawal**: Allows a signed-in user to withdraw an amount, provided there are sufficient funds.
4. **Deposit**: Enables users to deposit an amount into their account.
5. **Balance Check**: Shows the current balance of the signed-in user.
6. **Bank Statement**: Displays the transaction history for the signed-in user.

## File Structure

Each user has a dedicated text file under the `Task_03` directory:
- **File Name**: `<username>.txt`
- **Contents**:
  - Password: Stored in the first line for validation during sign-in.
  - Current Balance: Updated after each transaction.
  - Transaction History: Each transaction, including date, type, and amount, is recorded.

## Usage

### Running the Program

1. **Compile** the program:
   ```bash
   javac Task_03/ATMInterface.java
   ```

2. **Run** the program:
   ```bash
   java Task_03.ATMInterface
   ```

### User Options

- **Main Menu**:
  - Enter **(1)** to sign up.
  - Enter **(2)** to sign in.
  - Enter **'done'** to exit the program.

- **After Signing In**:
  - Enter **(3)** for a withdrawal.
  - Enter **(4)** for a deposit.
  - Enter **(5)** to check the balance.
  - Enter **(6)** to view the bank statement.
  - Enter **'done'** to exit the program.

### Example Usage

1. **Sign Up**:
   - Choose `(1)` from the main menu to create an account.
   - Enter a username and password to create the account.

2. **Sign In**:
   - Choose `(2)` and enter your username and password.

3. **Transaction Options**:
   - Once signed in, follow the options to make a withdrawal, deposit, check balance, or view your transaction history.

### Notes

- Ensure you have read/write permissions for the `Task_03` directory, as the program creates and modifies user files in this folder.
- User account files are stored in plain text, so handle user data with care if using this code in a real environment.

## License

This program is intended for educational purposes. Feel free to modify and use the code in non-commercial projects.
