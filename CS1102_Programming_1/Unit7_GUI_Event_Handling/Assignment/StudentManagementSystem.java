import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * StudentManagementSystem.java
 * Main GUI application for the Student Management System.
 * Built using Java Swing with event-driven programming.
 *
 * This class creates the graphical interface and implements all event handlers
 * for student management, course enrollment, and grade assignment.
 * Data operations are delegated to the DataManager class.
 *
 * @author Nicanor Kyamba
 * @course CS 1102 — Programming 1, Unit 7
 */
public class StudentManagementSystem extends JFrame {

    // ─── Data Layer ──────────────────────────────────────────────────────────
    private DataManager dataManager;

    // ─── GUI Components ──────────────────────────────────────────────────────
    private JTabbedPane tabbedPane;

    // Student Management tab
    private DefaultTableModel studentTableModel;
    private JTable studentTable;

    // Course Enrollment tab
    private JComboBox<String> enrollCourseBox;
    private DefaultTableModel eligibleStudentModel;
    private JTable eligibleStudentTable;
    private DefaultTableModel enrollmentTableModel;

    // Grade Management tab
    private JComboBox<String> gradeStudentBox;
    private JComboBox<String> gradeCourseBox;
    private JTextField gradeField;
    private DefaultTableModel gradeDisplayModel;

    /**
     * Constructor — initializes the data layer and builds the GUI.
     */
    public StudentManagementSystem() {
        dataManager = new DataManager();

        setTitle("Student Management System");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        createMenuBar();

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Student Management", createStudentPanel());
        tabbedPane.addTab("Course Enrollment", createEnrollmentPanel());
        tabbedPane.addTab("Grade Management", createGradePanel());
        add(tabbedPane);

        setVisible(true);
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // MENU BAR
    // ═══════════════════════════════════════════════════════════════════════════

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu studentMenu = new JMenu("Student");
        studentMenu.setMnemonic(KeyEvent.VK_S);
        JMenuItem addItem = new JMenuItem("Add Student");
        addItem.addActionListener(e -> showAddStudentDialog());
        JMenuItem updateItem = new JMenuItem("Update Student");
        updateItem.addActionListener(e -> showUpdateStudentDialog());
        JMenuItem viewItem = new JMenuItem("View Student Details");
        viewItem.addActionListener(e -> { tabbedPane.setSelectedIndex(0); refreshStudentTable(); });
        studentMenu.add(addItem);
        studentMenu.add(updateItem);
        studentMenu.add(viewItem);

        JMenu enrollMenu = new JMenu("Enrollment");
        JMenuItem enrollItem = new JMenuItem("Enroll Student");
        enrollItem.addActionListener(e -> tabbedPane.setSelectedIndex(1));
        enrollMenu.add(enrollItem);

        JMenu gradesMenu = new JMenu("Grades");
        JMenuItem assignItem = new JMenuItem("Assign Grade");
        assignItem.addActionListener(e -> tabbedPane.setSelectedIndex(2));
        gradesMenu.add(assignItem);

        menuBar.add(fileMenu);
        menuBar.add(studentMenu);
        menuBar.add(enrollMenu);
        menuBar.add(gradesMenu);
        setJMenuBar(menuBar);
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // TAB 1: STUDENT MANAGEMENT
    // ═══════════════════════════════════════════════════════════════════════════

    private JPanel createStudentPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        btnPanel.setBorder(BorderFactory.createTitledBorder("Actions"));
        JButton addBtn = new JButton("Add Student");
        JButton updateBtn = new JButton("Update Student");
        JButton viewBtn = new JButton("View Student Details");
        addBtn.addActionListener(e -> showAddStudentDialog());
        updateBtn.addActionListener(e -> showUpdateStudentDialog());
        viewBtn.addActionListener(e -> refreshStudentTable());
        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(viewBtn);

        studentTableModel = new DefaultTableModel(
            new String[]{"Student ID", "Full Name", "Email", "Courses Enrolled"}, 0
        ) { public boolean isCellEditable(int r, int c) { return false; } };
        studentTable = new JTable(studentTableModel);
        studentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        studentTable.setRowHeight(25);
        JScrollPane scrollPane = new JScrollPane(studentTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Student Records"));

        panel.add(btnPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private void showAddStudentDialog() {
        JTextField idField = new JTextField(15);
        JTextField nameField = new JTextField(15);
        JTextField emailField = new JTextField(15);

        JPanel form = new JPanel(new GridLayout(3, 2, 5, 5));
        form.add(new JLabel("Student ID:"));  form.add(idField);
        form.add(new JLabel("Full Name:"));   form.add(nameField);
        form.add(new JLabel("Email:"));       form.add(emailField);

        int result = JOptionPane.showConfirmDialog(this, form,
            "Add New Student", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String email = emailField.getText().trim();

            if (id.isEmpty() || name.isEmpty() || email.isEmpty()) {
                showError("All fields are required. Please fill in ID, Name, and Email.");
                return;
            }
            if (!email.contains("@") || !email.contains(".")) {
                showError("Please enter a valid email address.");
                return;
            }
            try {
                dataManager.addStudent(new Student(id, name, email));
                refreshAll();
                showSuccess("Student '" + name + "' (ID: " + id + ") added successfully!");
            } catch (IllegalArgumentException ex) {
                showError(ex.getMessage());
            }
        }
    }

    private void showUpdateStudentDialog() {
        ArrayList<Student> students = dataManager.getStudents();
        if (students.isEmpty()) {
            showWarning("No students in the system. Please add a student first.");
            return;
        }

        String[] options = new String[students.size()];
        for (int i = 0; i < students.size(); i++) {
            options[i] = students.get(i).toString();
        }

        String selected = (String) JOptionPane.showInputDialog(this,
            "Select a student to update:", "Update Student",
            JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (selected == null) return;

        String selectedId = selected.split(" - ")[0];
        Student student = dataManager.findStudent(selectedId);
        if (student == null) return;

        JTextField nameField = new JTextField(student.getFullName(), 15);
        JTextField emailField = new JTextField(student.getEmail(), 15);

        JPanel form = new JPanel(new GridLayout(3, 2, 5, 5));
        form.add(new JLabel("Student ID:"));  form.add(new JLabel(student.getStudentId()));
        form.add(new JLabel("Full Name:"));   form.add(nameField);
        form.add(new JLabel("Email:"));       form.add(emailField);

        int result = JOptionPane.showConfirmDialog(this, form,
            "Update Student: " + student.getStudentId(),
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String newName = nameField.getText().trim();
            String newEmail = emailField.getText().trim();
            if (newName.isEmpty() || newEmail.isEmpty()) {
                showError("Name and Email cannot be empty.");
                return;
            }
            student.setFullName(newName);
            student.setEmail(newEmail);
            refreshAll();
            showSuccess("Student information updated successfully!");
        }
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // TAB 2: COURSE ENROLLMENT
    // ═══════════════════════════════════════════════════════════════════════════

    private JPanel createEnrollmentPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        topPanel.setBorder(BorderFactory.createTitledBorder("Select Course"));
        topPanel.add(new JLabel("Course:"));
        enrollCourseBox = new JComboBox<>();
        for (Course c : dataManager.getCourses()) {
            enrollCourseBox.addItem(c.getDisplayName());
        }
        enrollCourseBox.addActionListener(e -> refreshEligibleStudents());
        topPanel.add(enrollCourseBox);
        JButton enrollBtn = new JButton("Enroll Selected Student");
        enrollBtn.addActionListener(e -> enrollSelectedStudent());
        topPanel.add(enrollBtn);

        eligibleStudentModel = new DefaultTableModel(
            new String[]{"Student ID", "Name", "Email", "Status"}, 0
        ) { public boolean isCellEditable(int r, int c) { return false; } };
        eligibleStudentTable = new JTable(eligibleStudentModel);
        eligibleStudentTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        eligibleStudentTable.setRowHeight(25);
        JScrollPane eligibleScroll = new JScrollPane(eligibleStudentTable);
        eligibleScroll.setBorder(BorderFactory.createTitledBorder("Eligible Students for Enrollment"));

        enrollmentTableModel = new DefaultTableModel(
            new String[]{"Student ID", "Student Name", "Course"}, 0
        ) { public boolean isCellEditable(int r, int c) { return false; } };
        JTable enrollmentTable = new JTable(enrollmentTableModel);
        enrollmentTable.setRowHeight(25);
        JScrollPane enrollScroll = new JScrollPane(enrollmentTable);
        enrollScroll.setBorder(BorderFactory.createTitledBorder("All Current Enrollments"));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, eligibleScroll, enrollScroll);
        splitPane.setDividerLocation(200);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(splitPane, BorderLayout.CENTER);
        return panel;
    }

    private void refreshEligibleStudents() {
        eligibleStudentModel.setRowCount(0);
        if (enrollCourseBox.getSelectedItem() == null) return;
        String selectedCourse = (String) enrollCourseBox.getSelectedItem();

        for (Student s : dataManager.getStudents()) {
            String status = dataManager.isEnrolled(s.getStudentId(), selectedCourse)
                ? "Already Enrolled" : "Eligible";
            eligibleStudentModel.addRow(new Object[]{
                s.getStudentId(), s.getFullName(), s.getEmail(), status});
        }
    }

    private void enrollSelectedStudent() {
        int row = eligibleStudentTable.getSelectedRow();
        if (row == -1) {
            showWarning("Please select a student from the eligible students list.");
            return;
        }
        String studentId = (String) eligibleStudentModel.getValueAt(row, 0);
        String studentName = (String) eligibleStudentModel.getValueAt(row, 1);
        String status = (String) eligibleStudentModel.getValueAt(row, 3);
        String course = (String) enrollCourseBox.getSelectedItem();

        if ("Already Enrolled".equals(status)) {
            showWarning(studentName + " is already enrolled in " + course + ".");
            return;
        }
        try {
            dataManager.enrollStudent(studentId, course);
            refreshEligibleStudents();
            refreshEnrollmentTable();
            refreshStudentTable();
            showSuccess(studentName + " enrolled in " + course + " successfully!");
        } catch (IllegalArgumentException ex) {
            showError(ex.getMessage());
        }
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // TAB 3: GRADE MANAGEMENT
    // ═══════════════════════════════════════════════════════════════════════════

    private JPanel createGradePanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel topPanel = new JPanel(new GridLayout(4, 2, 8, 8));
        topPanel.setBorder(BorderFactory.createTitledBorder("Assign Grade"));
        topPanel.add(new JLabel("Select Student:"));
        gradeStudentBox = new JComboBox<>();
        gradeStudentBox.addActionListener(e -> onGradeStudentSelected());
        topPanel.add(gradeStudentBox);
        topPanel.add(new JLabel("Select Course:"));
        gradeCourseBox = new JComboBox<>();
        topPanel.add(gradeCourseBox);
        topPanel.add(new JLabel("Grade (A, A-, B+, B, B-, C+, C, C-, D, F):"));
        gradeField = new JTextField(5);
        topPanel.add(gradeField);
        topPanel.add(new JLabel());
        JButton assignBtn = new JButton("Assign Grade");
        assignBtn.addActionListener(e -> assignGrade());
        topPanel.add(assignBtn);

        gradeDisplayModel = new DefaultTableModel(
            new String[]{"Course", "Grade"}, 0
        ) { public boolean isCellEditable(int r, int c) { return false; } };
        JTable gradeDisplayTable = new JTable(gradeDisplayModel);
        gradeDisplayTable.setRowHeight(25);
        JScrollPane scrollPane = new JScrollPane(gradeDisplayTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder(
            "Enrolled Courses and Current Grades (for selected student)"));

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private void onGradeStudentSelected() {
        gradeDisplayModel.setRowCount(0);
        gradeCourseBox.removeAllItems();
        if (gradeStudentBox.getSelectedItem() == null) return;

        String entry = (String) gradeStudentBox.getSelectedItem();
        String studentId = entry.split(" - ")[0];
        ArrayList<String> enrolled = dataManager.getEnrolledCourses(studentId);

        if (enrolled.isEmpty()) {
            gradeDisplayModel.addRow(new Object[]{"(No courses enrolled)", "-"});
            return;
        }
        for (String course : enrolled) {
            String grade = dataManager.getGrade(studentId, course);
            gradeDisplayModel.addRow(new Object[]{course, grade});
            gradeCourseBox.addItem(course);
        }
    }

    private void assignGrade() {
        if (gradeStudentBox.getSelectedItem() == null) {
            showWarning("Please select a student first.");
            return;
        }
        if (gradeCourseBox.getSelectedItem() == null) {
            showWarning("No courses available. The student must be enrolled first.");
            return;
        }
        String gradeValue = gradeField.getText().trim().toUpperCase();
        String entry = (String) gradeStudentBox.getSelectedItem();
        String studentId = entry.split(" - ")[0];
        String course = (String) gradeCourseBox.getSelectedItem();

        try {
            dataManager.assignGrade(studentId, course, gradeValue);
            onGradeStudentSelected();
            gradeField.setText("");
            Student student = dataManager.findStudent(studentId);
            showSuccess("Grade '" + gradeValue + "' assigned to " +
                student.getFullName() + " for " + course + ".");
        } catch (IllegalArgumentException ex) {
            showError(ex.getMessage());
        }
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // DYNAMIC REFRESH METHODS
    // ═══════════════════════════════════════════════════════════════════════════

    private void refreshAll() {
        refreshStudentTable();
        refreshEligibleStudents();
        refreshEnrollmentTable();
        refreshGradeStudentBox();
    }

    private void refreshStudentTable() {
        studentTableModel.setRowCount(0);
        for (Student s : dataManager.getStudents()) {
            int courseCount = dataManager.getEnrolledCourses(s.getStudentId()).size();
            studentTableModel.addRow(new Object[]{
                s.getStudentId(), s.getFullName(), s.getEmail(), courseCount});
        }
    }

    private void refreshEnrollmentTable() {
        enrollmentTableModel.setRowCount(0);
        for (String[] row : dataManager.getAllEnrollments()) {
            enrollmentTableModel.addRow(row);
        }
    }

    private void refreshGradeStudentBox() {
        gradeStudentBox.removeAllItems();
        for (Student s : dataManager.getStudents()) {
            gradeStudentBox.addItem(s.toString());
        }
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // DIALOG HELPERS
    // ═══════════════════════════════════════════════════════════════════════════

    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void showWarning(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Warning", JOptionPane.WARNING_MESSAGE);
    }

    private void showSuccess(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // MAIN METHOD
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Entry point — launches the application on the Event Dispatch Thread.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentManagementSystem());
    }
}
