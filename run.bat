@echo off
chcp 65001 > nul
cd /d "%~dp0"
if exist out rmdir /s /q out
mkdir out
if exist sources.txt del sources.txt
for /r src %%f in (*.java) do echo %%f>>sources.txt
javac -encoding UTF-8 -d out @sources.txt
if errorlevel 1 (
    echo.
    echo Ошибка компиляции. Проверьте наличие JDK и исходные файлы.
    pause
    exit /b 1
)
echo.
echo Компиляция завершена успешно.
echo.
java -Dfile.encoding=UTF-8 -cp out practice5.Main
pause
