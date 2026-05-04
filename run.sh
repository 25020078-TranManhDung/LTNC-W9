#!/bin/bash

echo "Bat dau build Maven local..."
chmod +x mvnw
./mvnw clean package

if [ $? -eq 0 ]; then
    echo "SUCCESS: Build va test thanh cong! File .jar da tao o thu muc 'target/'."
    echo "Ban co the commit va push code len GitHub."
else
    echo "FAILED: Build hoac test that bai! Hay kiem tra lai log loi o tren."
fi