import Screen.ARCHIVE_LIST_SCREEN
import Screen.NOTE_LIST_SCREEN
import choose.NoteListScreen
import choose.NoteScreen

/**
 * Индекс выбранного архива. По умолчанию выбран нулевой
 */
private var archiveIndex = 0

/**
 * Выводит на экран список доступных опций.
 * Затем считывает пользовательский ввод и проверяет его валидность.
 * После выполняет действие, соответствующее данному вводу.
 *
 * @param [screen] Экран
 */
fun openScreen(screen: Screen) {
    while (true) {
        printText(screen)
        val clientInput = scanner.nextLine().toIntOrNull()
        when {
            (clientInput == null || clientInput < 0) -> {
                println("Введено некорректное значение! Введите, пожалуйста, неотрицательное число")
            }
            clientInput == getThreshold(screen) -> {
                return
            }
            clientInput > getThreshold(screen) -> {
                println("Нет пункта меню с номером '$clientInput'! Введите, пожалуйста, другое неотрицательное число.")
            }
            else -> {
                if (clientInput == 0) {
                    // необходимо чтобы добавлять архив в начало списка
                    if (screen == ARCHIVE_LIST_SCREEN) archiveIndex = clientInput
                    screen.createScreen.create(archiveIndex)
                } else {
                    when (screen) {
                        ARCHIVE_LIST_SCREEN -> {
                            if (screen == ARCHIVE_LIST_SCREEN) archiveIndex = clientInput
                            NoteListScreen().getNoteList(archiveIndex - 1)
                        }
                        NOTE_LIST_SCREEN -> NoteScreen().getNote(archiveIndex, clientInput - 1)
                    }
                }
            }
        }
    }
}

/**
 * Выводит на экран список доступных опций.
 *
 * @param [screen] Экран
 */
private fun printText(
    screen: Screen
) {
    val itemList = getList(screen)
    val exitNumber = getThreshold(screen)
    val text = getItemListNames(itemList, screen, exitNumber)
    println(text)
}

/**
 * Возвращает максимальное значение, которое может ввести пользователь, с учетом доступных опций.
 *
 * @param [screen] Экран
 * @return Максимальное значение
 */
fun getThreshold(screen: Screen): Int {
    val itemList = when (screen) {
        ARCHIVE_LIST_SCREEN -> {
            archiveList.map { it.first }
        }
        NOTE_LIST_SCREEN -> {
            archiveList[archiveIndex - 1].second.map { it.name }
        }
    }
    return itemList.size + 1
}

/**
 *  Возвращает список всех элементов на выбранном экране
 *
 *  @param [screen] Экран
 *  @return Список всех элементов
 */
fun getList(screen: Screen): List<String> {
    return when (screen) {
        ARCHIVE_LIST_SCREEN -> {
            archiveList.map { it.first }
        }
        NOTE_LIST_SCREEN -> {
            archiveList[archiveIndex - 1].second.map { it.name }
        }
    }
}

/**
 * Возвращает текст всех возможных опций на экране.
 *
 * @param [itemList] Список всех элементов
 * @param [screen] Экран
 * @param [exitNumber] Номер пункта, соответствующий опции 'Выход/Возврат на предыдущий экран'
 * @return Текст всех возможных опций, доступных пользователю
 */
private fun getItemListNames(itemList: List<String>, screen: Screen, exitNumber: Int): String {
    var itemNames = ""
    itemList.forEachIndexed { index, item ->
        itemNames += "${index + 1}. $item\n"
    }
    val exitText = if (screen == ARCHIVE_LIST_SCREEN) "Выход" else "Вернуться на предыдущий экран"
    return "${screen.screenName}:\n0. ${screen.actionName}\n$itemNames$exitNumber. $exitText"
}
