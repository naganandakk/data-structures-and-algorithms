/*
 * Copyright (c) 2021.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the
 * Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NON-INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
 * DEALINGS IN THE SOFTWARE.
 */

package com.naganandakk.dsa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PhoneBookTest {

  @Test
  void shouldAddContactToPhoneBook() {
    PhoneBook phoneBook = new PhoneBook();

    Assertions.assertTrue( phoneBook.addContact("Name 1", "1234567890"));
  }

  @Test
  void shouldRetrieveCorrectContactInPhoneBook() {
    PhoneBook phoneBook = new PhoneBook();
    String name = "Name 1";
    String phoneNumber = "1234567890";

    phoneBook.addContact(name, phoneNumber);

    Assertions.assertEquals(phoneNumber, phoneBook.getContact(name));
  }

  @Test
  void shouldThrowErrorWhenContactNotFoundInPhoneBook() {
    PhoneBook phoneBook = new PhoneBook();
    String name = "Name 1";
    String phoneNumber = "1234567890";

    phoneBook.addContact(name, phoneNumber);

    Assertions.assertEquals(phoneNumber, phoneBook.getContact(name));

    Assertions.assertThrows(RuntimeException.class, () -> {phoneBook.getContact("Unknown Name");});
  }
}
